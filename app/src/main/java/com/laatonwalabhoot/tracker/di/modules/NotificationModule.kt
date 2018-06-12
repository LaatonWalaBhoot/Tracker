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

    private val APP_OPEN_CODE = 101
    private val SERVICE_CLOSE_CODE = 102

    @Provides
    @ApplicationScope
    fun notification(): Notification {

        return NotificationCompat.Builder(context, "MY_CH_ID")
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentText(context.getString(R.string.tracking_background))
                .setContentTitle(context.getString(R.string.app_name))
                .addAction(android.R.drawable.ic_menu_close_clear_cancel,
                        context.getString(R.string.stop_tracking),
                        PendingIntent.getBroadcast(context, SERVICE_CLOSE_CODE,
                                Intent(context, StopTrackingReceiver::class.java), 0))
                .setContentIntent(PendingIntent.getActivity(context, APP_OPEN_CODE,
                        Intent(context, MainActivity::class.java), 0))
                .build()
    }
}