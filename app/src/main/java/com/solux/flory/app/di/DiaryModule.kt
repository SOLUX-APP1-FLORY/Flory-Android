package com.solux.flory.app.di

import com.solux.flory.data.datasource.DiaryDataSource
import com.solux.flory.data.datasourceimpl.DiaryDataSourceImpl
import com.solux.flory.data.repositoryimpl.DiaryRepositoryImpl
import com.solux.flory.data.service.DiaryApiService
import com.solux.flory.domain.repository.DiaryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiaryModule {
    @Provides
    @Singleton
    fun provideDiaryService(
        @FloryRetrofit retrofit: Retrofit,
    ): DiaryApiService = retrofit.create(DiaryApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsDiaryRepository(repositoryImpl: DiaryRepositoryImpl): DiaryRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Binds
        @Singleton
        fun providesDiaryDataSource(dataSourceImpl: DiaryDataSourceImpl): DiaryDataSource
    }
}