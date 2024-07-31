package com.solux.flory.app.interceptor

import com.solux.flory.data.datasource.UserPreferencesDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import javax.inject.Inject

class TokenInterceptor @Inject
constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
        var accessToken = userPreferencesDataSource.getUserAccessToken().first()

        val request = chain.request().newBuilder()
            .addHeader("Authorization", "$accessToken")
            .build()

        val response = chain.proceed(request)
        Timber.tag("interceptor").d("accessToken $accessToken")

        response
    }
}