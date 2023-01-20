package ru.maxsdev.funnel.main

import ru.maxsdev.resources.Res

class GreetingsViewState constructor(
    val date: Res.Text,
    val greetings: Res.Text
) {
    companion object {
        val EMPTY = GreetingsViewState(date = Res.Text.Simple(""), greetings = Res.Text.Simple(""))
    }
}
