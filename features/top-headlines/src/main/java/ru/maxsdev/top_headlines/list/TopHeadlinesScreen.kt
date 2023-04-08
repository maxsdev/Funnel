package ru.maxsdev.top_headlines.list

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
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
    val articles = viewModel.news().collectAsLazyPagingItems()

    Log.d("TESTLOG", "load state: ${articles.loadState}")
//    if (articles.loadState.refresh is LoadState.Loading) {
//        LoadingStateView()
//    } else {
    TopHeadlinesList(articles = articles)
//    }
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
