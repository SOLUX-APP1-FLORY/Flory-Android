package com.solux.flory.app.di

import com.solux.flory.data.datasource.LetterDataSource
import com.solux.flory.data.datasourceimpl.LetterDataSourceImpl
import com.solux.flory.data.repositoryimpl.LetterRepositoryImpl
import com.solux.flory.data.service.LetterApiService
import com.solux.flory.domain.repository.LetterRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LetterModule {
    @Provides
    @Singleton
    fun provideLetterService(
        @FloryRetrofit retrofit: Retrofit,
    ): LetterApiService = retrofit.create(LetterApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsLetterRepository(repositoryImpl: LetterRepositoryImpl): LetterRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Binds
        @Singleton
        fun providesLetterDataSource(dataSourceImpl: LetterDataSourceImpl): LetterDataSource
    }
}