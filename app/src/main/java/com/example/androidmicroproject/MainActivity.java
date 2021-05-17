package com.example.androidmicroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.androidmicroproject.repository.SqliteRepository;
import com.example.androidmicroproject.repository.WeatherRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherRepository repository = new SqliteRepository(this);

        repository.defaultEntry();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weathers, R.layout.custom_drop_down_item);
        adapter.setDropDownViewResource(R.layout.custom_drop_down_item);
//        adapter.setDropDownViewTheme();
        spinner.setAdapter(adapter);
    }
}