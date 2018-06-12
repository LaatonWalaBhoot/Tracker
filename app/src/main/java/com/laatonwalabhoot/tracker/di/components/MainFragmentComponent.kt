package com.laatonwalabhoot.tracker.di.components

import com.laatonwalabhoot.tracker.di.modules.EventListAdapterModule
import com.laatonwalabhoot.tracker.di.modules.EventReceiverModule
import com.laatonwalabhoot.tracker.di.modules.IntentFilterModule
import com.laatonwalabhoot.tracker.di.modules.LinearLayoutManagerModule
import com.laatonwalabhoot.tracker.di.scopes.PerFragmentScope
import com.laatonwalabhoot.tracker.ui.main.MainFragment
import dagger.Component

@Component(modules = [EventListAdapterModule::class,
    LinearLayoutManagerModule::class], dependencies = [AppComponent::class])

@PerFragmentScope
interface MainFragmentComponent {

    fun injectMainFragment(mainFragment: MainFragment)
}
