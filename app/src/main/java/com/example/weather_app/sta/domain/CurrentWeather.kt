package com.example.weather_app.sta.domain

data class CurrentWeather(
    val temp:Float,
    val uv:Float,
    val cloud:Float,
    val aq: Float,
    val text: String
)
