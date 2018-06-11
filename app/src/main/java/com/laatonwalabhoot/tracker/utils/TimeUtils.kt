package com.laatonwalabhoot.tracker.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtils {

    private val dateFormat: SimpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
    private val date: Date = Calendar.getInstance().time

    companion object {
        fun newInstance() = TimeUtils()
    }

    fun getCurrentTime(): String {
        return dateFormat.format(date)
    }
}