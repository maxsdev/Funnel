package ru.maxsdev.di

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.savedstate.SavedStateRegistryOwner

class Factory<T : ViewModel>(
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val create: (stateHandle: SavedStateHandle) -> T
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return create.invoke(handle) as T
    }
}

inline fun <reified T : ViewModel> ViewModelBuilder.lazyViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
) = buildViewModel<T> {
    Factory(this, create)
}

@MainThread
inline fun <reified VM : ViewModel> ViewModelBuilder.buildViewModel(
    noinline extrasProducer: (() -> CreationExtras)? = null,
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = null
): VM {
    val factory = factoryProducer?.invoke() ?: defaultViewModelProviderFactory

    Log.d("TESTLOG", "viewModel creating. Store: $viewModelStore")
    return ViewModelProvider(
        viewModelStore,
        factory,
        extrasProducer?.invoke() ?: this.defaultViewModelCreationExtras
    )[VM::class.java]

}
