package com.absa.openweatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "weather_response")
data class WeatherResponse (

        @Json(name = "coord")
        val coord: Coord,
        val weather: List<Weather>,
        @Json(name = "base")
        val base: String,
        @Json(name = "main")
        val main: Main,
        @Json(name = "visibility")
        val visibility: Long,
        @Json(name = "wind")
        val wind: Wind,
        @Json(name = "clouds")
        val clouds: Clouds,
        @Json(name = "dt")
        val dt: Long,
        @Json(name = "sys")
        val sys: Sys,
        @Json(name = "timezone")
        val timezone: Long,
        @PrimaryKey
        val id: Long,
        @Json(name = "name")
        val name: String,
        @Json(name = "cod")
        val cod: Long
)

@JsonClass(generateAdapter = true)
data class Clouds (
        @Json(name = "all")
        val all: Long
)

@JsonClass(generateAdapter = true)
data class Coord (
        @Json(name = "lon")
        val lon: Double,
        @Json(name = "lat")
        val lat: Double
)

@JsonClass(generateAdapter = true)
data class Main (
        @Json(name = "temp")
        val temp: Double,

        @Json(name = "feels_like")
        val feelsLike: Double,

        @Json(name = "temp_min")
        val tempMin: Double,

        @Json(name = "temp_max")
        val tempMax: Double,
        @Json(name = "pressure")
        val pressure: Long,
        @Json(name = "humidity")
        val humidity: Long
)

@JsonClass(generateAdapter = true)
data class Sys (
        @Json(name = "type")
        val type: Long,
        @Json(name = "id")
        val id: Long,
        @Json(name = "country")
        val country: String,
        @Json(name = "sunrise")
        val sunrise: Long,
        @Json(name = "sunset")
        val sunset: Long
)
@JsonClass(generateAdapter = true)
data class Weather (
        @Json(name = "id")
        val id: Long,
        @Json(name = "main")
        val main: String,
        @Json(name = "description")
        val description: String,
        @Json(name = "icon")
        val icon: String
)

@JsonClass(generateAdapter = true)
data class Wind (
        @Json(name = "speed")
        val speed: Double,
        @Json(name = "dep")
        val deg: Long
)