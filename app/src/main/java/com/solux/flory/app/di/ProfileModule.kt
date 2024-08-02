package com.solux.flory.app.di

import com.solux.flory.data.datasource.ProfileDataSource
import com.solux.flory.data.datasourceimpl.ProfileDataSourceImpl
import com.solux.flory.data.repositoryimpl.ProfileRepositoryImpl
import com.solux.flory.data.service.ProfileApiService
import com.solux.flory.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {
    @Provides
    @Singleton
    fun provideProfileService(
        @FloryRetrofit retrofit: Retrofit,
    ): ProfileApiService = retrofit.create(ProfileApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsProfileRepository(RepositoryImpl: ProfileRepositoryImpl): ProfileRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Binds
        @Singleton
        fun providesProfileDataSource(DataSourceImpl: ProfileDataSourceImpl): ProfileDataSource
    }
}