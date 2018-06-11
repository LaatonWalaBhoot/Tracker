package com.laatonwalabhoot.tracker.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.laatonwalabhoot.tracker.data.models.Event
import com.laatonwalabhoot.tracker.R

class EventViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val mEventName: TextView = view.findViewById(R.id.event_name)
    private val mEventStamp: TextView = view.findViewById(R.id.event_stamp)

    fun setItem(event: Event?) {
        mEventName.text = event?.event
        mEventStamp.text = event?.stamp
    }
}