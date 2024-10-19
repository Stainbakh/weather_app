package com.example.weather_app.sta.data

import com.example.weather_app.sta.domain.Weather
import com.example.weather_app.sta.domain.WeatherRepo
import javax.inject.Inject


class WeatherRepoImpl @Inject constructor(
    private val weatherApi:WeatherApi
): WeatherRepo{
    override suspend fun getCurrentWeather(city:String):Weather {
        val networkWeather = weatherApi.getCurrentWeather(city)

        return Weather(
            networkWeather.location.name,
            networkWeather.current.temp,
            networkWeather.current.uv,
            networkWeather.current.cloud,
            networkWeather.current.aq,
            if (networkWeather.current.condition.text.equals("Sunny", ignoreCase = true)) {
                Weather.Type.Sunny
            } else {
                Weather.Type.Cloudy
            }
        )
    }
}