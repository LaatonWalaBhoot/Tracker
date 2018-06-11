package com.laatonwalabhoot.tracker.di.modules

import android.content.IntentFilter
import com.laatonwalabhoot.tracker.di.scopes.PerFragmentScope
import dagger.Module
import dagger.Provides

@Module
class IntentFilterModule {

    @Provides
    @PerFragmentScope
    fun intentFilter(): IntentFilter {
        return IntentFilter()
    }
}