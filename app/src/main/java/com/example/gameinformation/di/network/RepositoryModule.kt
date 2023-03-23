package com.example.gameinformation.di.network

import android.content.Context
import com.example.gameinformation.features.homedetail.data.repository.DetailRepositoryImpl
import com.example.gameinformation.features.homedetail.domain.repository.DetailRepository
import com.example.gameinformation.features.homedetail.domain.source.GameDetailSource
import com.example.gameinformation.features.home.data.repository.GetGamesRepositoryImpl
import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import com.example.gameinformation.features.stores.data.repository.StoreRepositoryImpl
import com.example.gameinformation.features.stores.domain.repository.StoreRepository
import com.example.gameinformation.features.stores.domain.source.StoreDataSource
import com.example.gameinformation.features.storesdetail.data.repository.StoresDetailRepositoryImpl
import com.example.gameinformation.features.storesdetail.domain.repository.StoresDetailRepository
import com.example.gameinformation.features.storesdetail.domain.source.StoreDetailDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(gamesDataSource: GamesDataSource,@ApplicationContext context : Context):GetGamesRepository =GetGamesRepositoryImpl(gamesDataSource, context )

    @Provides
    @Singleton
    fun provideDetailsRepository(gameDetailSource: GameDetailSource):DetailRepository =DetailRepositoryImpl(gameDetailSource)

    @Provides
    @Singleton
    fun provideStoreRepository(storeDataSource: StoreDataSource): StoreRepository =
        StoreRepositoryImpl(storeDataSource)

    @Provides
    @Singleton
    fun provideStoreDetailRepository(storeDetailDataSource:StoreDetailDataSource):StoresDetailRepository=
        StoresDetailRepositoryImpl(storeDetailDataSource)
}