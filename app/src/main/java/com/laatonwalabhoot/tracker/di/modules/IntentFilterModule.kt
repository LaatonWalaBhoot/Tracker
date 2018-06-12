package com.laatonwalabhoot.tracker.di.modules

import android.content.IntentFilter
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class IntentFilterModule {

    @Provides
    @ApplicationScope
    fun intentFilter(): IntentFilter {
        return IntentFilter()
    }
}