package com.solux.flory.app.di

import com.solux.flory.data.datasource.NeighborDataSource
import com.solux.flory.data.datasourceimpl.NeighborDataSourceImpl
import com.solux.flory.data.repositoryimpl.NeighborRepositoryImpl
import com.solux.flory.data.service.NeighborApiService
import com.solux.flory.domain.repository.NeighborRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NeighborModule {
    @Provides
    @Singleton
    fun provideNeighborService(
        @FloryRetrofit retrofit: Retrofit,
    ): NeighborApiService = retrofit.create(NeighborApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsNeighborRepository(repositoryImpl: NeighborRepositoryImpl): NeighborRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Binds
        @Singleton
        fun providesNeighborDataSource(dataSourceImpl: NeighborDataSourceImpl): NeighborDataSource
    }
}