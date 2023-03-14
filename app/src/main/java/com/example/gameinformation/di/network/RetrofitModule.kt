package com.example.gameinformation.di.network

import com.example.gameinformation.features.detail.data.api.GameDetailService
import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.features.stores.data.api.StoresService
import com.example.gameinformation.utilty.constants.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun getInterceptor():Interceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun getHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitApi(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideHomeService(retrofit: Retrofit): GameService =
        retrofit.create(GameService::class.java)

    @Singleton
    @Provides
    fun provideDetailService(retrofit: Retrofit): GameDetailService =
        retrofit.create(GameDetailService::class.java)


    @Singleton
    @Provides
    fun provideStoreService(retrofit:Retrofit):StoresService=
        retrofit.create(StoresService::class.java)
}
