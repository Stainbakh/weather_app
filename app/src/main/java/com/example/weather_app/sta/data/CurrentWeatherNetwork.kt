package com.example.weather_app.sta.data

import com.google.gson.annotations.SerializedName


data class CurrentWeatherNetwork(@SerializedName("location") val location: Location,
                                 @SerializedName("current") val current: Current
    ){
    data class Location(@SerializedName("name") val name: String)
    data class Current(
        @SerializedName("temp_c") val temp: Float,
        @SerializedName("uv") val uv: Float,
        @SerializedName("cloud") val cloud: Float,
        @SerializedName("humidity") val aq: Float,
        @SerializedName("condition") val condition: Condition
        ){
            data class Condition(
                @SerializedName("text") val text: String
            )
        }
    }

