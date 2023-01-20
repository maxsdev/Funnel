package ru.maxsdev.resources

import androidx.annotation.StringRes

sealed interface Res {
    sealed interface Text : Res {
        class Resource(@StringRes val resId: Int) : Text
        class Simple(val text: String) : Text
    }
}
