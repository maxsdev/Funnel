package ru.maxsdev.top_headlines

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.maxsdev.api.NewsAPISource
import ru.maxsdev.api.dto.ArticleDto

class TopHeadlinesPagingSource constructor(
    private val newsSource: NewsAPISource
) : PagingSource<Int, ArticleDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDto> {
        return try {
            val page = params.key ?: 1
            val response = newsSource.getTopHeadlines(page = page)

            val prevKey = if (page == 1) null else page - 1
            val nextKey = if (!response.articles.isNullOrEmpty()) page + 1 else null

            LoadResult.Page(
                data = response.articles ?: emptyList(),
                prevKey = prevKey,
                nextKey = nextKey,
            )
//                .apply { Log.d("TESTLOG", "LoadResult: $this") }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
