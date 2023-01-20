package ru.maxsdev.api.model

enum class Category {
    GENERAL,
    BUSINESS,
    SPORTS,
    TECHNOLOGY,
    ENTERTAINMENT,
    HEALTH,
    SCIENCE;

    val id: String = name.lowercase()
    val tabName: String = name.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}
