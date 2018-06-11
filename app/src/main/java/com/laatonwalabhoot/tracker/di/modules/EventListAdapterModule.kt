package com.laatonwalabhoot.tracker.di.modules

import com.laatonwalabhoot.tracker.di.scopes.PerFragmentScope
import com.laatonwalabhoot.tracker.ui.main.EventListAdapter
import dagger.Module
import dagger.Provides

@Module
class EventListAdapterModule {

    @Provides
    @PerFragmentScope
    fun eventListAdapter(): EventListAdapter {
        return EventListAdapter()
    }
}