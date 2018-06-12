package com.laatonwalabhoot.tracker.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.laatonwalabhoot.tracker.db.TrackerDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val applicationContext: Context) {

    private lateinit var trackerDb: TrackerDb

    @Provides
    @Singleton
    fun database(): TrackerDb {
       trackerDb = Room.databaseBuilder(applicationContext, TrackerDb::class.java,"Tracker-DB")
               .build()
        return trackerDb
    }
}