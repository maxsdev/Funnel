package ru.maxsdev.api

import ru.maxsdev.api.dto.ArticlesDto
import javax.inject.Inject

class NewsAPISource @Inject constructor(
    private val api: NewsAPI
) {

    suspend fun getTopHeadlines(): ArticlesDto = api.topHeadlines("us", "72ae5d3ddca641e8bb97ef03d1d15f1a")

}
