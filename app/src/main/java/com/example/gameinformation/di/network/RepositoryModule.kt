package com.example.gameinformation.di.network

import com.example.gameinformation.features.home.data.repository.GetGamesRepositoryImpl
import com.example.gameinformation.features.home.domain.repository.GetGamesRepository
import com.example.gameinformation.features.home.domain.source.GamesDataSource
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

}