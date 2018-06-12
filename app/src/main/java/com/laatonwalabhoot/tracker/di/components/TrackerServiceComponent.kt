package com.laatonwalabhoot.tracker.di.components

import com.laatonwalabhoot.tracker.data.services.TrackerService
import com.laatonwalabhoot.tracker.di.modules.EventModule
import com.laatonwalabhoot.tracker.di.modules.EventReceiverModule
import com.laatonwalabhoot.tracker.di.modules.IntentFilterModule
import com.laatonwalabhoot.tracker.di.modules.NotificationModule
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import dagger.Component

@Component(modules = [EventReceiverModule::class,
    IntentFilterModule::class,
    NotificationModule::class,
    EventModule::class], dependencies = [AppComponent::class])

@ApplicationScope
interface TrackerServiceComponent {

    fun injectTrackerService(trackerService: TrackerService)
}