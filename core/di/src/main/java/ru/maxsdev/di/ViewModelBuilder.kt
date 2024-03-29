package ru.maxsdev.di

import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModelStoreOwner
import androidx.savedstate.SavedStateRegistryOwner

interface ViewModelBuilder : HasDefaultViewModelProviderFactory, ViewModelStoreOwner, SavedStateRegistryOwner
