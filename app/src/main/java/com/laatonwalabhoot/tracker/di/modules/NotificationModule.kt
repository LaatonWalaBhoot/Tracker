package com.laatonwalabhoot.tracker.di.modules

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.app.NotificationCompat
import com.laatonwalabhoot.tracker.R
import com.laatonwalabhoot.tracker.data.receivers.StopTrackingReceiver
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import com.laatonwalabhoot.tracker.ui.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class NotificationModule(private val context: Context) {

    @Provides
    @ApplicationScope
    fun notification(): Notification {

        return NotificationCompat.Builder(context, "MY_CH_ID")
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentText("Tracking in Background")
                .setContentTitle("Tracker")
                .addAction(android.R.drawable.ic_menu_close_clear_cancel,"Stop Tracking",
                        PendingIntent.getBroadcast(context,101,
                        Intent(context, StopTrackingReceiver::class.java),0))
                .setContentIntent(PendingIntent.getActivity(context,102,
                        Intent(context,MainActivity::class.java), 0))
                .build()
    }
}