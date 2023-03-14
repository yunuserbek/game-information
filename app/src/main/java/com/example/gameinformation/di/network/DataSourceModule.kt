package com.example.gameinformation.di.network

import com.example.gameinformation.features.detail.data.api.GameDetailService
import com.example.gameinformation.features.detail.data.source.GameDetailSourceImpl
import com.example.gameinformation.features.detail.domain.source.GameDetailSource
import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.features.home.data.source.GamesDataSourceImpl
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import com.example.gameinformation.features.stores.data.api.StoresService
import com.example.gameinformation.features.stores.data.source.StoreDataSourceImpl
import com.example.gameinformation.features.stores.domain.source.StoreDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.intellij.lang.annotations.PrintFormat
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDatasource(gameService: GameService): GamesDataSource =
        GamesDataSourceImpl(gameService)

    @Provides
    @Singleton
    fun provideRemoteDetailSource(gameDetailService: GameDetailService): GameDetailSource =
        GameDetailSourceImpl(gameDetailService)

    @Provides
    @Singleton
    fun provideRemoteStoreSource(storeService: StoresService): StoreDataSource =
        StoreDataSourceImpl(storeService)


}