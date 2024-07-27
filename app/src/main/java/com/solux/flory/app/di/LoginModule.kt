package com.solux.flory.app.di

import com.solux.flory.data.datasource.UserPreferencesDataSource
import com.solux.flory.data.datasourceimpl.UserPreferencesDataSourceImpl
import com.solux.flory.data.repositoryimpl.UserPreferencesRepositoryImpl
import com.solux.flory.domain.repository.UserPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsLoginRepository(RepositoryImpl: UserPreferencesRepositoryImpl): UserPreferencesRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Singleton
        @Binds
        fun providesLoginDataSource(DataSourceImpl: UserPreferencesDataSourceImpl): UserPreferencesDataSource
    }
}