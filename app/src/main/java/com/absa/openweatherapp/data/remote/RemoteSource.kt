package com.absa.openweatherapp.data.remote

import com.absa.openweatherapp.data.model.WeatherResponse


interface RemoteSource {
    suspend fun fetchWeather(location: String): WeatherResponse
}