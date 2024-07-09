package com.example.weather_app.sta.data

import com.example.weather_app.sta.domain.CurrentWeather
import com.example.weather_app.sta.domain.WeatherRepo
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val weatherApi:WeatherApi
): WeatherRepo{
    override suspend fun getCurrentWeather(city:String):CurrentWeather {
        val networkWeather = weatherApi.getCurrentWeather(city)
        return CurrentWeather(
            networkWeather.temp,
            networkWeather.uv,
            networkWeather.cloud,
            networkWeather.aq,
            networkWeather.text
        )
    }
}