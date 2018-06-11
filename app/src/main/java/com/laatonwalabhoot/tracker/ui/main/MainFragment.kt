package com.laatonwalabhoot.tracker.ui.main

import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laatonwalabhoot.tracker.EventReceiver
import com.laatonwalabhoot.tracker.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var eventListAdapter: EventListAdapter
    private lateinit var eventReceiver: EventReceiver
    private lateinit var intentFilter: IntentFilter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setReceiver()
    }

    private fun setAdapter() {
        eventListAdapter = EventListAdapter()
        event_list.layoutManager = LinearLayoutManager(context)
        event_list.adapter = eventListAdapter
    }

    private fun setReceiver() {
        eventReceiver = EventReceiver()
        intentFilter = IntentFilter()
        eventReceiver.setEventListener(eventListAdapter.getListener())
        intentFilter.addAction("android.intent.action.USER_PRESENT")
        intentFilter.addAction("android.intent.action.SCREEN_ON")
        intentFilter.addAction("android.intent.action.SCREEN_OFF")
        activity?.registerReceiver(eventReceiver, intentFilter)
    }
}
