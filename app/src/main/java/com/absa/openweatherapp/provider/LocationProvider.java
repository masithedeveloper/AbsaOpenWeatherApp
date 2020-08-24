package com.absa.openweatherapp.provider;

import org.jetbrains.annotations.NotNull;

import com.absa.openweatherapp.data.model.Coord;

public interface LocationProvider {

    boolean isLocationChanged(String location);

    @NotNull  String getPreferredLocationString();
}
