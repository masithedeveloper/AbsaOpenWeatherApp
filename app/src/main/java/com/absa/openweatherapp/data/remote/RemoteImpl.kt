package com.absa.openweatherapp.data.remote

import com.absa.openweatherapp.data.model.WeatherResponse
import com.absa.openweatherapp.data.remote.api.ApiService
import javax.inject.Inject

class RemoteImpl @Inject constructor(private val apiService: ApiService) : RemoteSource {

    override suspend fun fetchWeather(location: String): WeatherResponse {
        return apiService.getWeather(location)
    }
}