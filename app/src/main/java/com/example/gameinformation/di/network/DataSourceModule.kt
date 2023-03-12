package com.example.gameinformation.di.network

import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.features.home.data.source.GamesDataSourceImpl
import com.example.gameinformation.features.home.domain.source.GamesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideREmoteDatasource(gameService: GameService):GamesDataSource = GamesDataSourceImpl(gameService)
}