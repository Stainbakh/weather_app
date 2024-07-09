package com.example.weather_app.sta.data

import com.google.gson.annotations.SerializedName

data class CurrentWeatherNetwork(
    @SerializedName("temp_c") val temp: Float,
    @SerializedName("uv") val uv: Float,
    @SerializedName("cloud") val cloud: Float,
    @SerializedName("humidity") val aq: Float,
    @SerializedName("text") val text: String
)
