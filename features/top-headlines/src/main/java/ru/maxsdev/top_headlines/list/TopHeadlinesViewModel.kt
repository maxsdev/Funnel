package ru.maxsdev.top_headlines.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ru.maxsdev.api.dto.ArticleDto
import ru.maxsdev.top_headlines.TopHeadlinesRepository

class TopHeadlinesViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    private val repository: TopHeadlinesRepository
) : ViewModel() {
    var uiState by mutableStateOf(HeadlinesUiState())
        private set

    init {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                val articles = repository.getTopHeadlines()
//                update(articles.articles)
//            }
//        }
    }

    fun news(): Flow<PagingData<ArticleDto>> =
        repository.getNews()
//            .cachedIn(viewModelScope)

    private suspend fun update(articles: List<ArticleDto>?) {
        withContext(Dispatchers.Main) {
            uiState = uiState.copy(articles = articles ?: emptyList())
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): TopHeadlinesViewModel
    }
}
