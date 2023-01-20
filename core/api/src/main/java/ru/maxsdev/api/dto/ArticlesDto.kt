package ru.maxsdev.api.dto

import ru.maxsdev.api.model.Status

data class ArticlesDto constructor(
    val status: Status? = null,
    val totalResults: Int? = null,
    val articles: List<ArticleDto>? = null,
    val code: Int? = null,
    val message: String? = null
)
