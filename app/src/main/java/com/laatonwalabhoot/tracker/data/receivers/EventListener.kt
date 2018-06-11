package com.laatonwalabhoot.tracker.data.receivers

import com.laatonwalabhoot.tracker.data.models.Event

interface EventListener {

    fun onEvent(event: Event)
}