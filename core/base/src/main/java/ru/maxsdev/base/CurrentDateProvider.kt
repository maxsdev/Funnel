package ru.maxsdev.base

import java.time.LocalDateTime

class CurrentDateProvider : DateProvider {
    override val date: LocalDateTime
        get() = LocalDateTime.now()
}
