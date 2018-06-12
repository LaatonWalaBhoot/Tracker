package com.laatonwalabhoot.tracker.data.services

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import com.laatonwalabhoot.tracker.Tracker
import com.laatonwalabhoot.tracker.data.receivers.EventListener
import com.laatonwalabhoot.tracker.data.receivers.EventReceiver
import com.laatonwalabhoot.tracker.db.Database
import com.laatonwalabhoot.tracker.db.entity.Event
import com.laatonwalabhoot.tracker.di.components.DaggerTrackerServiceComponent
import com.laatonwalabhoot.tracker.di.components.TrackerServiceComponent
import com.laatonwalabhoot.tracker.di.modules.NotificationModule
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TrackerService: Service(), EventListener {

    private lateinit var component: TrackerServiceComponent
    private val event: Event = Event()

    @Inject
    lateinit var eventReceiver: EventReceiver

    @Inject
    lateinit var intentFilter: IntentFilter

    @Inject
    lateinit var notification: Notification

    @Inject
    lateinit var database: Database


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(intent==null) {
            return START_NOT_STICKY
        }
        startForeground(1001, notification)
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerTrackerServiceComponent.builder()
                .notificationModule(NotificationModule(context = applicationContext))
                .appComponent(Tracker.newInstance().getApp(this).getAppComponent())
                .build()
        component.injectTrackerService(this)
        intentFilter.addAction("android.intent.action.USER_PRESENT")
        intentFilter.addAction("android.intent.action.SCREEN_ON")
        intentFilter.addAction("android.intent.action.SCREEN_OFF")
        eventReceiver.setEventListener(this)
        registerReceiver(eventReceiver, intentFilter)
    }

    override fun onEvent(name: String, stamp: String) {
        Completable.create {
            event.event = name
            event.stamp = stamp
            database.daoAccess().insertOnlySingleRecord(event)
            it.onComplete()
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun onDestroy() {
        unregisterReceiver(eventReceiver)
        super.onDestroy()
    }
}