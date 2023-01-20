package ru.maxsdev.funnel.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.maxsdev.funnel.main.MainActivity
import ru.maxsdev.top_headlines.list.TopHeadlinesScreen

@Composable
fun Main(
    activity: MainActivity,
    navController: NavController
) {
    TopHeadlinesScreen(
        viewModelBuilder = activity,
        dependencies = activity.appComponent(),
        navController = navController
    )
}
