package com.laatonwalabhoot.tracker.di.modules

import com.laatonwalabhoot.tracker.data.receivers.EventReceiver
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import com.laatonwalabhoot.tracker.di.scopes.PerFragmentScope
import dagger.Module
import dagger.Provides

@Module
class EventReceiverModule {

    @Provides
    @ApplicationScope
    fun eventReciever(): EventReceiver {
        return EventReceiver()
    }
}