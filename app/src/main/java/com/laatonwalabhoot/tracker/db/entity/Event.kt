package com.laatonwalabhoot.tracker.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Event {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var event: String = ""
    var stamp: String = ""
}