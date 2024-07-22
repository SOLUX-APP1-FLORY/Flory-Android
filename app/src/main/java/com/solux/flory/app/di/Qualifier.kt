package com.solux.flory.app.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FloryRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AccessToken