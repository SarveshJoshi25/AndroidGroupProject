package com.example.androidmicroproject.repository;

import android.content.Context;

import com.example.androidmicroproject.model.Weather;

public class SqliteRepository implements WeatherRepository {
    WeatherDBHelper helper;

    public SqliteRepository(Context context) {
        helper = new WeatherDBHelper(context);
    }

    @Override
    public Weather defaultEntry() {
        return WeatherDBHelper.firstRow;
    }

    @Override
    public void insert(Weather weather) {
        helper.insert(weather);
    }

    @Override
    public Weather weatherOf(String city) {
        return null;
    }
}
