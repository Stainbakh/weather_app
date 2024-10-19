package com.example.weather_app.sta.domain

data class Weather(
    val location: String,
    val temp:Float,
    val uv:Float,
    val cloud:Float,
    val aq: Float,
    val type:Type

){
    enum class Type{
        Sunny, Cloudy
    }

}
