package com.example.gameinformation.di.network

import com.example.gameinformation.features.homedetail.data.api.GameDetailService
import com.example.gameinformation.features.homedetail.data.source.GameDetailSourceImpl
import com.example.gameinformation.features.homedetail.domain.source.GameDetailSource
import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.features.home.data.source.GamesDataSourceImpl
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import com.example.gameinformation.features.stores.data.api.StoresService
import com.example.gameinformation.features.stores.data.source.StoreDataSourceImpl
import com.example.gameinformation.features.stores.domain.source.StoreDataSource
import com.example.gameinformation.features.storesdetail.data.api.StoresDetailService
import com.example.gameinformation.features.storesdetail.data.source.StoreDetailDataSourceImpl
import com.example.gameinformation.features.storesdetail.domain.source.StoreDetailDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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


    @Provides
    @Singleton
    fun provideRemoteStoreDetailSource(storesDetailService: StoresDetailService): StoreDetailDataSource =
        StoreDetailDataSourceImpl(storesDetailService)
}