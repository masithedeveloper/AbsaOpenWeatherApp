package com.absa.openweatherapp.di.module;

import dagger.Binds;
import dagger.Module;
import com.absa.openweatherapp.data.local.LocalDataSource;
import com.absa.openweatherapp.data.local.LocalDataSourceImpl;
import com.absa.openweatherapp.data.remote.RemoteImpl;
import com.absa.openweatherapp.data.remote.RemoteSource;
import com.absa.openweatherapp.repository.Repository;
import com.absa.openweatherapp.repository.WeatherRepository;

@Module
public abstract class DataSourceModule {

    @Binds
    abstract LocalDataSource provideDataSource(LocalDataSourceImpl localDataSource);

    @Binds
    abstract Repository provideRepoImpl(WeatherRepository repo);

    @Binds
    abstract RemoteSource provideRemoteImpl(RemoteImpl remote);
}

