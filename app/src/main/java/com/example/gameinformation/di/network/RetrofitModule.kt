package com.example.gameinformation.di.network

import com.example.gameinformation.BuildConfig
import com.example.gameinformation.features.home.data.api.GameService
import com.example.gameinformation.utilty.constants.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
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
    fun getHttpClient(interceptor: Interceptor):OkHttpClient{
        return  OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
    @Provides
    @Singleton
    fun provideRetrofitApi(client:OkHttpClient):GameService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(GameService::class.java)
    }
}