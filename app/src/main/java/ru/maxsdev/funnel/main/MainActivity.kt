package ru.maxsdev.funnel.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.maxsdev.base.CurrentDateProvider
import ru.maxsdev.di.ViewModelBuilder
import ru.maxsdev.funnel.App
import ru.maxsdev.funnel.di.AppComponent
import ru.maxsdev.funnel.navigation.Main
import ru.maxsdev.funnel.screen.Main
import ru.maxsdev.funnel.view.TopAppBar
import ru.maxsdev.resources.Res
import ru.maxsdev.theme.FunnelTheme

class MainActivity : ComponentActivity(), ViewModelBuilder {

    private lateinit var viewModel: MainViewModel

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, MainViewModelFactory(CurrentDateProvider()))[MainViewModel::class.java]

        setContent {
            FunnelTheme {
                val viewState by viewModel.greetingsViewState.observeAsState(GreetingsViewState.EMPTY)
                Column {
                    TopAppBar(date = viewState.date.asString(), header = viewState.greetings.asString())
                    Content(activity = this@MainActivity)
                }
            }
        }
    }

    fun appComponent(): AppComponent = (applicationContext as App).appComponent

    private fun Res.asString(): String = when (this) {
        is Res.Text.Resource -> getString(resId)
        is Res.Text.Simple -> text
    }
}

@Composable
fun Content(activity: MainActivity) {
    Column {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Main.destination) {
            composable(Main.destination) {
                Main(activity = activity, navController = navController)
            }
        }
    }
}



