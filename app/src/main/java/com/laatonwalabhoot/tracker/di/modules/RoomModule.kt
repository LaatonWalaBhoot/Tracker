package com.laatonwalabhoot.tracker.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.laatonwalabhoot.tracker.db.Database
import com.laatonwalabhoot.tracker.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val applicationContext: Context) {

    private lateinit var database: Database

    @Provides
    @Singleton
    fun database(): Database {
       database = Room.databaseBuilder(applicationContext, Database::class.java,"Tracker-DB")
               .build()
        return database
    }
}