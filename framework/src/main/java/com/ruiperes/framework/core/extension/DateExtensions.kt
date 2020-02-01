package com.ruiperes.framework.core.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.isWeekend(): Boolean {
    val cal = Calendar.getInstance().apply {
        time = this@isWeekend
    }

    return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
}

fun Date.isFriday(): Boolean {
    val cal = Calendar.getInstance().apply {
        time = this@isFriday
    }

    return cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
}

fun Date.addDays(days: Int): Date {
    val cal = Calendar.getInstance().apply {
        time = this@addDays
    }

    cal.add(Calendar.DATE, days)
    return cal.time
}

fun Date.toCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
}

fun Date.randomFromDateToDate(endDate: Date): Date {
    return Date(kotlin.random.Random.nextLong(this.time, endDate.time))
}

fun Long.toDate(): Date = Date(this)
fun Date.toLong(): Long = this.time

fun Long.toDateWithHour(hour: Int): Date {
    val cal = this.toDate().toCalendar()
    cal.set(Calendar.HOUR_OF_DAY, hour)
    return cal.time
}

fun Date.age(): Int {

    val dob = this.toCalendar()
    val today = Calendar.getInstance()

    var age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
        age--
    }

    return age
}

fun Long?.or(defaultValue: Long = 0): Long = this ?: defaultValue

fun String?.parseDate(): Date? {
    return try {
        val dateParser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        dateParser.parse(this!!)
    } catch (e: Exception) {
        null
    }

}

fun String?.parseDateWithMilliseconds(): Date? {
    return try {
        val dateParser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        dateParser.parse(this!!)
    } catch (e: Exception) {
        null
    }
}

fun Date?.toSimpleString(): String? {
    return try {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        return format.format(this!!)
    } catch (e: Exception) {
        null
    }
}