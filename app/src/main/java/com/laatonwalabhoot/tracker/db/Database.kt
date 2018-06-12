package com.laatonwalabhoot.tracker.db

import com.laatonwalabhoot.tracker.db.Dao.DaoAccess
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.laatonwalabhoot.tracker.db.entity.Event


@Database(entities = [(Event::class)], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun daoAccess(): DaoAccess
}