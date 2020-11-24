package com.example.carsales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SearchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=new Intent(this,SearchedCars.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
    }
}