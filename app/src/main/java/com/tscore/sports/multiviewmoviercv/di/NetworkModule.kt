package com.tscore.sports.multiviewmoviercv.di

import com.tscore.sports.multiviewmoviercv.network.MovieService
import com.tscore.sports.nativelib.NativeLib
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL= NativeLib().stringFromJNI()


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }


    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit.Builder): MovieService {
        return retrofit.build().create(MovieService::class.java)
    }


}