package com.example.gameinformation.di.network

import com.example.gameinformation.features.detail.data.repository.DetailRepositoryImpl
import com.example.gameinformation.features.detail.domain.repository.DetailRepository
import com.example.gameinformation.features.detail.domain.source.GameDetailSource
import com.example.gameinformation.features.home.data.repository.GetGamesRepositoryImpl
import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import com.example.gameinformation.features.stores.data.repository.StoreRepositoryImpl
import com.example.gameinformation.features.stores.domain.repository.StoreRepository
import com.example.gameinformation.features.stores.domain.source.StoreDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(gamesDataSource: GamesDataSource):GetGamesRepository =GetGamesRepositoryImpl(gamesDataSource)

    @Provides
    @Singleton
    fun provideDetailsRepository(gameDetailSource: GameDetailSource):DetailRepository =DetailRepositoryImpl(gameDetailSource)

    @Provides
    @Singleton
    fun provideStoreRepository(storeDataSource: StoreDataSource): StoreRepository =
        StoreRepositoryImpl(storeDataSource)
}