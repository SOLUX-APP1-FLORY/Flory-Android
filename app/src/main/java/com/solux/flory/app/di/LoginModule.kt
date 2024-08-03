package com.solux.flory.app.di

import com.solux.flory.data.datasource.LoginDataSource
import com.solux.flory.data.datasource.UserPreferencesDataSource
import com.solux.flory.data.datasourceimpl.LoginDataSourceImpl
import com.solux.flory.data.datasourceimpl.UserPreferencesDataSourceImpl
import com.solux.flory.data.repositoryimpl.LoginRepositoryImpl
import com.solux.flory.data.repositoryimpl.UserPreferencesRepositoryImpl
import com.solux.flory.data.service.LoginApiService
import com.solux.flory.domain.repository.LoginRepository
import com.solux.flory.domain.repository.UserPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Provides
    @Singleton
    fun provideLoginService(
        @FloryRetrofit retrofit: Retrofit,
    ): LoginApiService = retrofit.create(LoginApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsLoginRepository(RepositoryImpl: LoginRepositoryImpl): LoginRepository

        @Binds
        @Singleton
        fun bindsUserPreferencesRepository(RepositoryImpl: UserPreferencesRepositoryImpl): UserPreferencesRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Singleton
        @Binds
        fun providesLoginDataSource(DataSourceImpl: LoginDataSourceImpl): LoginDataSource
    }
}