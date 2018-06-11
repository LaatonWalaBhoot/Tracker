package com.laatonwalabhoot.tracker.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laatonwalabhoot.tracker.data.models.Event
import com.laatonwalabhoot.tracker.data.receivers.EventListener
import com.laatonwalabhoot.tracker.R
import kotlin.collections.ArrayList

class EventListAdapter: RecyclerView.Adapter<EventViewHolder>(), EventListener {

    private var eventList: ArrayList<Event>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun getItemCount(): Int {
        return when (eventList) {
            null -> 0
            else -> eventList!!.size
        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.setItem(eventList?.get(position))
    }

    override fun onEvent(event: Event) {
        eventList?.add(event)
        notifyDataSetChanged()
    }

    fun getListener(): EventListener {
        return this
    }
}