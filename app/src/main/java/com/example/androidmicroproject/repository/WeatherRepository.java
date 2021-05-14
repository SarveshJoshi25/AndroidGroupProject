package com.example.androidmicroproject.repository;

import com.example.androidmicroproject.model.Weather;

public interface WeatherRepository {
    Weather createDBIfNotExistsAndReturnDefaultEntry();
    Weather weatherOf(String city);
}
