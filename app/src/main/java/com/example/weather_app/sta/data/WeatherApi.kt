package com.example.weather_app.sta.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json?key=c8f88e4f1a5a43998d0112449241507&aqi=no")
    suspend fun getCurrentWeather(@Query("q") city:String): CurrentWeatherNetwork
}