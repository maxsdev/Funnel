package ru.maxsdev.top_headlines.list

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ru.maxsdev.api.model.Category
import ru.maxsdev.di.ViewModelBuilder
import ru.maxsdev.di.lazyViewModel
import ru.maxsdev.top_headlines.di.DaggerTopHeadlinesComponent
import ru.maxsdev.top_headlines.di.TopHeadlinesComponentDependencies

@Composable
fun TopHeadlinesScreen(
    viewModelBuilder: ViewModelBuilder,
    dependencies: TopHeadlinesComponentDependencies,
    navController: NavController
) {
    val viewModel = viewModelBuilder.diViewModel(dependencies)
    val uiState = viewModel.uiState
    TopHeadlinesList(articles = uiState.articles)
}

private fun ViewModelBuilder.diViewModel(
    dependencies: TopHeadlinesComponentDependencies
): TopHeadlinesViewModel = lazyViewModel { stateHandle ->
    DaggerTopHeadlinesComponent.builder()
        .dependencies(dependencies)
        .build()
        .topHeadlinesViewModel()
        .create(stateHandle)
}
