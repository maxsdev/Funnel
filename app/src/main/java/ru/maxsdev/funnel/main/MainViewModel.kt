package ru.maxsdev.funnel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import ru.maxsdev.base.DateProvider
import ru.maxsdev.funnel.R
import ru.maxsdev.resources.Res

class MainViewModel constructor(
    private val dateProvider: DateProvider
) : ViewModel() {
    private val _greetingsViewState: MutableLiveData<GreetingsViewState> = MutableLiveData()
    val greetingsViewState: LiveData<GreetingsViewState> = _greetingsViewState

    init {
        _greetingsViewState.value = createGreetings()
    }

    private fun createGreetings(): GreetingsViewState = GreetingsViewState(
        date = buildDate(dateProvider.date),
        greetings = getGreetings(dateProvider.timeOfDay)
    )

    private fun buildDate(date: LocalDateTime): Res.Text {
        val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.US)
        return Res.Text.Simple(date.format(formatter).uppercase())
    }

    private fun getGreetings(timeOfDay: DateProvider.TimeOfDay): Res.Text {
        return Res.Text.Resource(
            when (timeOfDay) {
                DateProvider.TimeOfDay.Afternoon -> R.string.header_good_afternoon
                DateProvider.TimeOfDay.Evening -> R.string.header_good_evening
                DateProvider.TimeOfDay.Morning -> R.string.header_good_morning
                DateProvider.TimeOfDay.Night -> R.string.header_good_night
            }
        )
    }

    companion object {
        private const val DATE_FORMAT = "EEEE, d MMMM"
    }
}
