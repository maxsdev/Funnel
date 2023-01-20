package ru.maxsdev.article

import androidx.lifecycle.SavedStateHandle
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ArticleViewModel @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) {
    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ArticleViewModel
    }
}
