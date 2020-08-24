package com.absa.openweatherapp.di.module;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import com.absa.openweatherapp.provider.LocationProvider;
import com.absa.openweatherapp.provider.LocationProviderImpl;

/**
 * @author masistoto
 */

@Module
public abstract class LocationModule {

    @Singleton
    @Binds
    abstract LocationProvider provideLocationProvider(LocationProviderImpl locationProvider);

}
