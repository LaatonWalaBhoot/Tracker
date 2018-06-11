package com.laatonwalabhoot.tracker.data.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.laatonwalabhoot.tracker.utils.TimeUtils
import com.laatonwalabhoot.tracker.data.models.Event

class EventReceiver: BroadcastReceiver() {

    private lateinit var eventListener: EventListener

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            Intent.ACTION_USER_PRESENT -> {
                eventListener.onEvent(Event("Phone Unlocked",
                        TimeUtils.newInstance().getCurrentTime()))
            }
            Intent.ACTION_SCREEN_ON -> {
                eventListener.onEvent(Event("Screen On",
                        TimeUtils.newInstance().getCurrentTime()))
            }
            Intent.ACTION_SCREEN_OFF -> {
                eventListener.onEvent(Event("Screen Off",
                        TimeUtils.newInstance().getCurrentTime()))
            }
        }
    }

    fun setEventListener(eventListener: EventListener) {
        this.eventListener = eventListener
    }
}