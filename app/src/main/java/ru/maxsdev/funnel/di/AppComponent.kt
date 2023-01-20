package ru.maxsdev.funnel.di

import dagger.Component
import ru.maxsdev.api.di.ApiModule
import ru.maxsdev.top_headlines.di.TopHeadlinesComponentDependencies
import javax.inject.Singleton

@[Singleton Component(modules = [ApiModule::class])]
interface AppComponent : TopHeadlinesComponentDependencies {
}
