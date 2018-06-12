package com.laatonwalabhoot.tracker.di.components

import com.laatonwalabhoot.tracker.db.Database
import com.laatonwalabhoot.tracker.di.modules.RoomModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RoomModule::class])
@Singleton
interface AppComponent {

    fun getDatabase(): Database
}