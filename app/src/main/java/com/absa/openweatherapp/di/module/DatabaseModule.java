package com.absa.openweatherapp.di.module;

import android.content.Context;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import com.absa.openweatherapp.data.local.db.WeatherDao;
import com.absa.openweatherapp.data.local.db.WeatherDatabase;


/**
 * @author masistoto
 */
@Module
public class DatabaseModule {

    @Provides
    @Singleton
    static WeatherDatabase provideDatabase(@NonNull Context context) {
        return Room.databaseBuilder(context,
                WeatherDatabase.class, "absa_weather_db")
                .build();
    }

    @Provides
    @Singleton
    static WeatherDao provideWeatherResponseDao(@NonNull WeatherDatabase appDatabase) {
        return appDatabase.weatherDao();
    }
}
