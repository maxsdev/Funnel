package ru.maxsdev.funnel

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}