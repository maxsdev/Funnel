package ru.maxsdev.base

import java.time.LocalDateTime

interface DateProvider {
    val date: LocalDateTime
    val timeOfDay: TimeOfDay
        get() = when (date.toLocalTime().hour) {
            in 0..3 -> TimeOfDay.Night
            in 4..11 -> TimeOfDay.Morning
            in 12..16 -> TimeOfDay.Afternoon
            else -> TimeOfDay.Evening
        }

    sealed interface TimeOfDay {
        object Morning : TimeOfDay
        object Afternoon : TimeOfDay
        object Evening : TimeOfDay
        object Night : TimeOfDay
    }
}
