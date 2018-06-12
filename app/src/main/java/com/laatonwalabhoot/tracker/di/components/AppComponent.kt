package com.laatonwalabhoot.tracker.di.components

import com.laatonwalabhoot.tracker.db.TrackerDb
import com.laatonwalabhoot.tracker.di.modules.RoomModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RoomModule::class])
@Singleton
interface AppComponent {

    fun getDatabase(): TrackerDb
}