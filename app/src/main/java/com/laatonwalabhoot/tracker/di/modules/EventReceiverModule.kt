package com.laatonwalabhoot.tracker.di.modules

import com.laatonwalabhoot.tracker.EventReceiver
import com.laatonwalabhoot.tracker.di.scopes.PerFragmentScope
import dagger.Module
import dagger.Provides

@Module
class EventReceiverModule {

    @Provides
    @PerFragmentScope
    fun eventReciever(): EventReceiver {
        return EventReceiver()
    }
}