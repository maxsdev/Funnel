package ru.maxsdev.funnel

import android.app.Application
import ru.maxsdev.funnel.di.AppComponent
import ru.maxsdev.funnel.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
