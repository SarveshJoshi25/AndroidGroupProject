package com.example.androidmicroproject.repository;

import com.example.androidmicroproject.model.Weather;

public class SqliteRepository implements WeatherRepository {
    @Override
    public Weather createDBIfNotExistsAndReturnDefaultEntry() {
        return null;
    }

    @Override
    public Weather weatherOf(String city) {
        return null;
    }
}
