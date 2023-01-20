package ru.maxsdev.top_headlines

import ru.maxsdev.api.NewsAPISource
import ru.maxsdev.api.dto.ArticlesDto
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(
    private val newsSource: NewsAPISource
) {
    suspend fun getTopHeadlines(): ArticlesDto = newsSource.getTopHeadlines()
}
