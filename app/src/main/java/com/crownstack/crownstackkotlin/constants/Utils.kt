package com.crownstack.crownstackkotlin.constants

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun getDateFormatFromUtcTimeFormat(timeStr: String?): String {
    timeStr?.let {
        val dateStr: Array<String> = timeStr.split("T").toTypedArray()
        return try {
            val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = dateFormat.parse(dateStr[0])
            val formatter: DateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            formatter.format(date ?: Date())
        } catch (e: Exception) {
            ""
        }
    }
    return ""
}

fun getSongDuration(timeInMillis: Long): String? {
    val durationInSeconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis)
    val minutes: Int
    val seconds: Int
    minutes = (durationInSeconds / 60).toInt()
    seconds = (durationInSeconds % 60).toInt()
    return "$minutes min, $seconds sec"
}