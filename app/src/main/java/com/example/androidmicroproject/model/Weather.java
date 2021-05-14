package com.example.androidmicroproject.model;

import java.time.LocalTime;

public class Weather {
    public final Temperature temperature;
    public final double humidity;
    public final String city, state, country;
    public final LocalTime sunriseTime, sunsetTime;
    public final int airQualityIndex;

    public Weather(Temperature temperature, double humidity, String city,
                   String state, String country, LocalTime sunriseTime,
                   LocalTime sunsetTime, int airQualityIndex) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.city = city;
        this.state = state;
        this.country = country;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.airQualityIndex = airQualityIndex;
    }
}
