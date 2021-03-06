package com.laatonwalabhoot.tracker.data.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.laatonwalabhoot.tracker.R
import com.laatonwalabhoot.tracker.utils.TimeUtils
import com.laatonwalabhoot.tracker.db.entity.Event

class EventReceiver : BroadcastReceiver() {

    private lateinit var eventListener: EventListener

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_USER_PRESENT -> {
                eventListener.onEvent(context!!.getString(R.string.phone_unlock),
                        TimeUtils.newInstance().getCurrentTime())
            }
            Intent.ACTION_SCREEN_ON -> {
                eventListener.onEvent(context!!.getString(R.string.screen_on),
                        TimeUtils.newInstance().getCurrentTime())
            }
            Intent.ACTION_SCREEN_OFF -> {
                eventListener.onEvent(context!!.getString(R.string.screen_off),
                        TimeUtils.newInstance().getCurrentTime())
            }
        }
    }

    fun setEventListener(eventListener: EventListener) {
        this.eventListener = eventListener
    }
}