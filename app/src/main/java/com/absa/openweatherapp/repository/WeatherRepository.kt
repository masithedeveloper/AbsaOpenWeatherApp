package com.absa.openweatherapp.repository

import android.content.Context
import android.content.SharedPreferences
import com.absa.openweatherapp.AppCoroutineDispatchers
import com.absa.openweatherapp.data.Resource
import com.absa.openweatherapp.data.local.LocalDataSource
import com.absa.openweatherapp.data.model.WeatherResponse
import com.absa.openweatherapp.data.remote.RemoteSource
import com.absa.openweatherapp.provider.LocationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
class WeatherRepository @Inject constructor(
        private val dispatcher: AppCoroutineDispatchers,
        private val remoteSource: RemoteSource,
        private val localDataSource: LocalDataSource,
        private val locationProvider: LocationProvider,
        private val prefEditor: SharedPreferences.Editor,
        private val context: Context
) : Repository {

    @ExperimentalCoroutinesApi
    override fun fetchWeather(): Flow<Resource<WeatherResponse>> {
        return flow<Resource<WeatherResponse>> {
            val currentData: WeatherResponse = localDataSource.getWeather().first()
            emit(Resource.Loading(currentData))
            fetchWeatherAndCache()
            emitAll(localDataSource.getWeather().map { Resource.Success(it) })
        }.catch { cause ->
            val previousData: WeatherResponse = localDataSource.getWeather().first()
            emit(Resource.Error(cause, previousData))
            cause.printStackTrace()
        }.flowOn(dispatcher.io)
    }

    private suspend fun fetchWeatherAndCache() {
        val weather: WeatherResponse = remoteSource
                .fetchWeather(locationProvider.preferredLocationString)
        localDataSource.save(weather)
    }

    private fun saveToPreferences(weather: WeatherResponse?) {
        weather?.let {
            if (it.weather[0].description.isNotEmpty()) {
                prefEditor.putString(WIDGET_TEXT, weather.weather[0].description)
                prefEditor.putString(WIDGET_LOCATION, weather.name)
                prefEditor.putString(WIDGET_ICON, weather.weather[0].description)
                prefEditor.apply()
            }
        }
    }

    companion object {
        const val WIDGET_TEXT: String = "com.absa.openweatherapp.ui.widget.text"
        const val WIDGET_LOCATION: String = "com.absa.openweatherapp.ui.widget.location"
        const val WIDGET_ICON: String = "com.absa.openweatherapp.ui.widget.icon"
    }
}