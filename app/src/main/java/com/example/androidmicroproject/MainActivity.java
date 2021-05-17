package com.example.androidmicroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidmicroproject.model.Weather;
import com.example.androidmicroproject.repository.SqliteRepository;
import com.example.androidmicroproject.repository.WeatherRepository;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherRepository repository = new SqliteRepository(this);

        Weather weather = repository.defaultEntry();

        repository.set(weather, new GregorianCalendar(2021, 5, 17));
    }
}