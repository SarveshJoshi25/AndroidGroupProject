package com.example.androidmicroproject.model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.example.androidmicroproject.DateTimeUtil.formatTime;

public class Weather {

    public final Temperature temperature;
    public final double humidity;
    public final String city, state, country;
    public final GregorianCalendar sunriseTime, sunsetTime;
    public final int airQualityIndex;
    public final Cloudiness cloudiness;

    public Weather(Temperature temperature, double humidity, String city,
                   String state, String country, GregorianCalendar sunriseTime,
                   GregorianCalendar sunsetTime, int airQualityIndex, Cloudiness cloudiness) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.city = city;
        this.state = state;
        this.country = country;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.airQualityIndex = airQualityIndex;
        this.cloudiness = cloudiness;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", sunriseTime=" + formatTime(sunriseTime) +
                ", sunsetTime=" + formatTime(sunsetTime) +
                ", airQualityIndex=" + airQualityIndex +
                ", cloudiness=" + cloudiness +
                '}';
    }
}
