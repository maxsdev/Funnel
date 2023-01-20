package ru.maxsdev.top_headlines.di

import dagger.Component
import dagger.Subcomponent
import ru.maxsdev.di.Feature
import ru.maxsdev.top_headlines.list.TopHeadlinesViewModel

@[Feature Component(modules = [TopHeadlinesModule::class], dependencies = [TopHeadlinesComponentDependencies::class])]
interface TopHeadlinesComponent {

    fun topHeadlinesViewModel(): TopHeadlinesViewModel.Factory

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: TopHeadlinesComponentDependencies): Builder
        fun build(): TopHeadlinesComponent
    }
}
