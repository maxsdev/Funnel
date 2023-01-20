package ru.maxsdev.api.model

import com.google.gson.annotations.SerializedName

enum class Status {
    @SerializedName("ok")
    OK,
    @SerializedName("error")
    ERROR
}
