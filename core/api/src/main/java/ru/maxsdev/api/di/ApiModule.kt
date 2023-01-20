package ru.maxsdev.api.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.maxsdev.api.NewsAPI
import ru.maxsdev.api.interceptors.AuthorizationInterceptor
import javax.inject.Singleton

@Module
abstract class ApiModule {
    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"

        @[Provides Singleton]
        fun provideGson(): Gson =
            GsonBuilder().create()

        @[Provides Singleton]
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        @[Provides Singleton]
        fun provideOkHttpClient(
            loggingInterceptor: HttpLoggingInterceptor,
            authorizationInterceptor: AuthorizationInterceptor
        ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(authorizationInterceptor)
                .addInterceptor(loggingInterceptor) // Logging всегда последний.
                .build()

        @[Provides Singleton]
        fun provideNewsApi(client: OkHttpClient, gson: Gson): NewsAPI =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
                .create(NewsAPI::class.java)
    }
}
