package ru.maxsdev.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        request = request.newBuilder()
            .header(HEADER_AUTHORIZATION, API_KEY)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val HEADER_AUTHORIZATION = "Authorization"
        private const val API_KEY = "72ae5d3ddca641e8bb97ef03d1d15f1a"
    }
}
