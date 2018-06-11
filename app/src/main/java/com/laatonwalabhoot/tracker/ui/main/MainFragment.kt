package com.laatonwalabhoot.tracker.ui.main

import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laatonwalabhoot.tracker.data.receivers.EventReceiver
import com.laatonwalabhoot.tracker.R
import com.laatonwalabhoot.tracker.di.components.DaggerMainFragmentComponent
import com.laatonwalabhoot.tracker.di.components.MainFragmentComponent
import com.laatonwalabhoot.tracker.di.modules.LinearLayoutManagerModule
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var component: MainFragmentComponent

    @Inject
    lateinit var eventListAdapter: EventListAdapter

    @Inject
    lateinit var eventReceiver: EventReceiver

    @Inject
    lateinit var intentFilter: IntentFilter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component = DaggerMainFragmentComponent.builder()
                .linearLayoutManagerModule(LinearLayoutManagerModule(context))
                .build()
        component.injectMainFragment(this)
        setAdapter()
        setReceiver()
    }

    private fun setAdapter() {
        event_list.layoutManager = linearLayoutManager
        event_list.adapter = eventListAdapter
    }

    private fun setReceiver() {
        eventReceiver.setEventListener(eventListAdapter.getListener())
        intentFilter.addAction("android.intent.action.USER_PRESENT")
        intentFilter.addAction("android.intent.action.SCREEN_ON")
        intentFilter.addAction("android.intent.action.SCREEN_OFF")
        activity?.registerReceiver(eventReceiver, intentFilter)
    }
}
