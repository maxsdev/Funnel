package ru.maxsdev.funnel.navigation

import ru.maxsdev.api.model.Category

sealed class Route(val destination: String)

sealed class TopHeadlines(val category: Category) : Route(destination = category.id) {
    object General : TopHeadlines(category = Category.GENERAL)
    object Business : TopHeadlines(category = Category.BUSINESS)
    object Sports : TopHeadlines(category = Category.SPORTS)
    object Technology : TopHeadlines(category = Category.TECHNOLOGY)
    object Entertainment : TopHeadlines(category = Category.ENTERTAINMENT)
    object Health : TopHeadlines(category = Category.HEALTH)
    object Science : TopHeadlines(category = Category.SCIENCE)

    companion object {
        val types: List<TopHeadlines> = listOf(
            General,
            Business,
            Sports,
            Technology,
            Entertainment,
            Health,
            Science
        )
    }
}

object Main : Route(destination = "main")
object Settings : Route(destination = "settings")
