package com.solux.flory.app.di

import com.solux.flory.data.datasource.SignUpDataSource
import com.solux.flory.data.datasourceimpl.SignUpDataSourceImpl
import com.solux.flory.data.repositoryimpl.SignUpRepositoryImpl
import com.solux.flory.data.service.SignUpApiService
import com.solux.flory.domain.repository.SignUpRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SignUpModule {
    @Provides
    @Singleton
    fun provideSignUpService(
        @FloryRetrofit retrofit: Retrofit,
    ): SignUpApiService = retrofit.create(SignUpApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsSignUpRepository(repositoryImpl: SignUpRepositoryImpl): SignUpRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Binds
        @Singleton
        fun providesSignUpDataSource(dataSourceImpl: SignUpDataSourceImpl): SignUpDataSource
    }
}