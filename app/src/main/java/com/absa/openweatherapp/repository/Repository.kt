package com.absa.openweatherapp.repository

import com.absa.openweatherapp.data.Resource
import com.absa.openweatherapp.data.model.WeatherResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetchWeather(): Flow<Resource<WeatherResponse>>
}