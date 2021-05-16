package com.example.androidmicroproject.repository;

import com.example.androidmicroproject.model.Weather;

public interface WeatherRepository {
    Weather defaultEntry();
    void insert(Weather weather);
    Weather weatherOf(String city);
}
