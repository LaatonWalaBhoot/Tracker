package com.laatonwalabhoot.tracker.di.modules

import com.laatonwalabhoot.tracker.db.entity.Event
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class EventModule {

    @Provides
    @ApplicationScope
    fun event() : Event {
        return Event()
    }
}