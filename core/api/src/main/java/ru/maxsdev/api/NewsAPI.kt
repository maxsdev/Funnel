package ru.maxsdev.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.maxsdev.api.dto.ArticlesDto

interface NewsAPI {
    @GET("top-headlines")
    suspend fun topHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int
    ): ArticlesDto
}
