package com.laatonwalabhoot.tracker.di.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.laatonwalabhoot.tracker.di.scopes.PerFragmentScope
import dagger.Module
import dagger.Provides

@Module
class LinearLayoutManagerModule(private val context: Context?) {

    @Provides
    @PerFragmentScope
    fun linearLayoutManager() : LinearLayoutManager {
        return LinearLayoutManager(context)
    }
}