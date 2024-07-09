package com.example.weather_app.sta.domain

interface WeatherRepo {
    suspend fun getCurrentWeather(city:String): CurrentWeather
}