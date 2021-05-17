package com.example.androidmicroproject.repository;

import com.example.androidmicroproject.model.Weather;

import java.util.GregorianCalendar;
import java.util.Optional;

public interface WeatherRepository {
    Weather defaultEntry();
    void set(Weather weather, GregorianCalendar date);
    Optional<Weather> weatherOf(String city, GregorianCalendar date);
}
