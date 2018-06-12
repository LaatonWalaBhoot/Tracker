package com.laatonwalabhoot.tracker.data.receivers

interface EventListener {

    fun onEvent(name: String, stamp: String)
}