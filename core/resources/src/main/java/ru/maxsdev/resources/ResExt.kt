package ru.maxsdev.resources

import androidx.annotation.StringRes

fun Res.assert(simpleString: String) {
    if (this is Res.Text.Simple) {
        assert(this.text == simpleString) { "Assertion failed. Value is ${this.text}, expected $simpleString" }
    } else {
        throw java.lang.IllegalArgumentException("Resource is ${this.javaClass.name}, expected Res.Text.Simple instance.")
    }
}

fun Res.assert(@StringRes stringResId: Int) {
    if (this is Res.Text.Resource) {
        assert(this.resId == stringResId) { "Assertion failed. Value is ${this.resId}, expected $stringResId" }
    } else {
        throw java.lang.IllegalArgumentException("Resource is ${this.javaClass.name}, expected Res.Text.Resource instance.")
    }
}
