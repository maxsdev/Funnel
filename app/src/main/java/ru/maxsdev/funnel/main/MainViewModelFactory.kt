package ru.maxsdev.funnel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maxsdev.base.DateProvider

class MainViewModelFactory constructor(
    private val dateProvider: DateProvider
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(dateProvider) as T
    }
}
