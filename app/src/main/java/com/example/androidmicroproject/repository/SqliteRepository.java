package com.example.androidmicroproject.repository;

import android.content.Context;

import com.example.androidmicroproject.model.Weather;

import java.util.GregorianCalendar;
import java.util.Optional;

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
    public void set(Weather weather, GregorianCalendar date) {
        helper.set(weather, date);
    }

    @Override
    public Weather weatherOf(String city, GregorianCalendar date) {
        return helper.weatherOf(city, date);
    }
}
