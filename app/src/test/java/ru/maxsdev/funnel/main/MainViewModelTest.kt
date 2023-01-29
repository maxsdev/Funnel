package ru.maxsdev.funnel.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import ru.maxsdev.base.DateProvider
import ru.maxsdev.funnel.R
import ru.maxsdev.resources.assert

internal class MainViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val lifecycleOwner: LifecycleOwner = mock(LifecycleOwner::class.java)

    @Test
    fun test_GreetingsViewState_10_00_10_Jan_2023() {
        mockLifecycle()
        val viewModel = MainViewModel(createDateProvider("2023-01-10T10:00:00.0"))
        viewModel.greetingsViewState
            .observe(lifecycleOwner) { viewState ->
                viewState.date.assert("TUESDAY, 10 JANUARY")
                viewState.greetings.assert(R.string.header_good_morning)
            }
    }

    @Test
    fun test_GreetingsViewState_15_00_21_Oct_2023() {
        mockLifecycle()
        val viewModel = MainViewModel(createDateProvider("2023-10-21T15:00:00.0"))
        viewModel.greetingsViewState
            .observe(lifecycleOwner) { viewState ->
                viewState.date.assert("SATURDAY, 21 OCTOBER")
                viewState.greetings.assert(R.string.header_good_afternoon)
            }
    }

    @Test
    fun test_GreetingsViewState_2_00_12_Oct_2023() {
        mockLifecycle()
        val viewModel = MainViewModel(createDateProvider("2023-10-12T02:00:00.0"))
        viewModel.greetingsViewState
            .observe(lifecycleOwner) { viewState ->
                viewState.date.assert("THURSDAY, 12 OCTOBER")
                viewState.greetings.assert(R.string.header_good_night)
            }
    }

    @Test
    fun test_GreetingsViewState_21_30_14_Aug_2023() {
        mockLifecycle()
        val viewModel = MainViewModel(createDateProvider("2023-08-14T21:30:00.0"))
        viewModel.greetingsViewState
            .observe(lifecycleOwner) { viewState ->
                viewState.date.assert("MONDAY, 14 AUGUST")
                viewState.greetings.assert(R.string.header_good_evening)
            }
    }

    private fun createDateProvider(pattern: String): DateProvider =
        object : DateProvider {
            private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
            override val date: LocalDateTime
                get() = LocalDateTime.parse(pattern, formatter)
        }

    private fun mockLifecycle() {
        val lifecycle = LifecycleRegistry(mock(LifecycleOwner::class.java))
        lifecycle.markState(Lifecycle.State.RESUMED)
        `when`(lifecycleOwner.lifecycle).thenReturn(lifecycle)
    }
}
