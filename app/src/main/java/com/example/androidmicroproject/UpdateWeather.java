package com.example.androidmicroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.androidmicroproject.model.Weather;
import com.example.androidmicroproject.repository.SqliteRepository;
import com.example.androidmicroproject.repository.WeatherRepository;

public class UpdateWeather extends AppCompatActivity {

    WeatherRepository repository = new SqliteRepository(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_weather);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weathers, R.layout.custom_drop_down_item);
        adapter.setDropDownViewResource(R.layout.custom_drop_down_item);
        spinner.setAdapter(adapter);
    }

    public void addWeather(View v) {
//        repository.insert(new Weather());
    }
}