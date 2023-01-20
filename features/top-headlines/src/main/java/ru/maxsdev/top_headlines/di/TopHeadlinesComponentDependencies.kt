package ru.maxsdev.top_headlines.di

import ru.maxsdev.api.NewsAPISource

interface TopHeadlinesComponentDependencies {
    val newsAPISource: NewsAPISource
}
