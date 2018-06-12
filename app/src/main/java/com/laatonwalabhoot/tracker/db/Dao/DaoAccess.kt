package com.laatonwalabhoot.tracker.db.Dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.laatonwalabhoot.tracker.db.entity.Event

@Dao
interface DaoAccess {

    @Insert
    fun insertOnlySingleRecord(event: Event)

    @Query("SELECT * FROM Event")
    fun fetchAllData(): LiveData<List<Event>>

}