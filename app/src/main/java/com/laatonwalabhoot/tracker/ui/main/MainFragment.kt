package com.laatonwalabhoot.tracker.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.laatonwalabhoot.tracker.R
import com.laatonwalabhoot.tracker.Tracker
import com.laatonwalabhoot.tracker.data.services.TrackerService
import com.laatonwalabhoot.tracker.db.TrackerDb
import com.laatonwalabhoot.tracker.db.entity.Event
import com.laatonwalabhoot.tracker.di.components.DaggerMainFragmentComponent
import com.laatonwalabhoot.tracker.di.components.MainFragmentComponent
import com.laatonwalabhoot.tracker.di.modules.LinearLayoutManagerModule
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment(){

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var component: MainFragmentComponent
    private lateinit var databaseLiveData: LiveData<List<Event>>

    @Inject
    lateinit var eventListAdapter: EventListAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    @Inject
    lateinit var trackerDb: TrackerDb

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component = DaggerMainFragmentComponent.builder()
                .linearLayoutManagerModule(LinearLayoutManagerModule(context))
                .appComponent(Tracker.newInstance().getApp(activity as MainActivity).getAppComponent())
                .build()
        component.injectMainFragment(this)
        activity?.startService(Intent(activity,TrackerService::class.java))
        setAdapter()
    }

    private fun setAdapter() {
        event_list.layoutManager = linearLayoutManager
        event_list.adapter = eventListAdapter
        databaseLiveData = trackerDb.daoAccess().fetchAllData()
        databaseLiveData.observe(this, Observer<List<Event>> {
            eventListAdapter.setList(it!!)
        })
    }
}
