package com.absa.openweatherapp.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.absa.openweatherapp.ui.activity.MainActivity;
import com.absa.openweatherapp.ui.fragment.WeatherFragment;

/**
 * @author masistoto
 */

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract WeatherFragment contributeWeatherFragment();
}
