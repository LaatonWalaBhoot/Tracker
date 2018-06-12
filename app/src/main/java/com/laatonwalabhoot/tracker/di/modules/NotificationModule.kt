package com.laatonwalabhoot.tracker.di.modules

import android.app.Notification
import android.content.Context
import android.support.v4.app.NotificationCompat
import com.laatonwalabhoot.tracker.R
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class NotificationModule(private val context: Context) {

    @Provides
    @ApplicationScope
    fun notification(): Notification {
        return NotificationCompat.Builder(context, "MY_CH_ID")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText("Tracking in Background")
                .setContentTitle("Tracker")
                .setContentIntent(null)
                .build()
    }
}