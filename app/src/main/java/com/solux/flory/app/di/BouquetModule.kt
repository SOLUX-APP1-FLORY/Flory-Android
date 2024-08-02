package com.solux.flory.app.di

import com.solux.flory.data.datasource.BouquetDataSource
import com.solux.flory.data.datasourceimpl.BouquetDataSourceImpl
import com.solux.flory.data.repositoryimpl.BouquetRepositoryImpl
import com.solux.flory.data.service.BouquetApiService
import com.solux.flory.domain.repository.BouquetRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BouquetModule {
    @Provides
    @Singleton
    fun provideBouquetService(
        @FloryRetrofit retrofit: Retrofit,
    ): BouquetApiService = retrofit.create(BouquetApiService::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface RepositoryModule {
        @Binds
        @Singleton
        fun bindsBouquetRepository(repositoryImpl: BouquetRepositoryImpl): BouquetRepository
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DataSourceModule {
        @Binds
        @Singleton
        fun providesBouquetDataSource(dataSourceImpl: BouquetDataSourceImpl): BouquetDataSource
    }
}