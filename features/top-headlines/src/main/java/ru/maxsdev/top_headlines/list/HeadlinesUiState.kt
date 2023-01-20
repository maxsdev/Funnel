package ru.maxsdev.top_headlines.list

import ru.maxsdev.api.dto.ArticleDto

data class HeadlinesUiState constructor(
    val articles: List<ArticleDto> = emptyList()
)
