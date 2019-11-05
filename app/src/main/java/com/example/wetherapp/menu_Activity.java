package com.example.wetherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class menu_Activity extends AppCompatActivity {
   ImageView openweather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       openweather = findViewById(R.id.imageView4);

        openweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_weather_activity();

            }
        });


    }

    public  void open_weather_activity(){
        Intent intent = new Intent(this, open_weather.class);
        startActivity(intent);
    }


}
