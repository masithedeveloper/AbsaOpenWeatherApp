package com.absa.openweatherapp.di.module;

import dagger.Binds;
import dagger.Module;
import com.absa.openweatherapp.provider.UnitProvider;
import com.absa.openweatherapp.provider.UnitProviderImpl;

/**
 * @author masistoto
 */
@Module
public abstract class UnitModule {

    @Binds
    abstract UnitProvider provideUnitProvider(UnitProviderImpl unitProvider);
}
