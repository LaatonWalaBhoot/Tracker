package com.laatonwalabhoot.tracker.data.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.laatonwalabhoot.tracker.data.services.TrackerService

class StopTrackingReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.stopService(Intent(context, TrackerService::class.java))
    }
}