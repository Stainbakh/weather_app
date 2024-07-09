package com.example.weather_app.sta.data

import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("&q={city}&aqi=no")
    suspend fun getCurrentWeather(@Path("city") city:String): CurrentWeatherNetwork
}