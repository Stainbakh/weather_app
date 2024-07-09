package com.example.weather_app.sta.di

import com.example.weather_app.sta.data.WeatherApi
import com.example.weather_app.sta.data.WeatherRepoImpl
import com.example.weather_app.sta.domain.WeatherRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn
class NetworkModule {
    @Provides

    @Singleton
    fun provideRetroClient():WeatherApi{
        val  retrofit = Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create<WeatherApi>()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule{
    @Binds
    @Reusable
    abstract fun bindWeatherRepo(impl: WeatherRepoImpl) : WeatherRepo
}