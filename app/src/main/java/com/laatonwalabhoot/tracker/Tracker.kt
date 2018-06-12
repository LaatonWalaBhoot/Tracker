package com.laatonwalabhoot.tracker

import android.app.Activity
import android.app.Application
import android.app.Service
import com.laatonwalabhoot.tracker.di.components.AppComponent
import com.laatonwalabhoot.tracker.di.components.DaggerAppComponent
import com.laatonwalabhoot.tracker.di.modules.RoomModule

class Tracker: Application() {

    private lateinit var component: AppComponent

    companion object {
        fun newInstance() = Tracker()
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .roomModule(RoomModule(this))
                .build()
    }

    fun getApp(activity: Activity): Tracker {
        return activity.application as Tracker
    }

    fun getApp(service: Service): Tracker{
        return service.application as Tracker
    }

    fun getAppComponent(): AppComponent {
        return component
    }
}