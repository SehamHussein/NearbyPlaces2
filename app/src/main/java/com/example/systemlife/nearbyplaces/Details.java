package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.systemlife.nearbyplaces.DataModels.NearModel;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent=getIntent();
        NearModel movieModel=(NearModel) getIntent().getSerializableExtra("nearModels");


    }
}
//AIzaSyCpTTibaozd7unbZKJtBjIIubWr5C_2iYo
//static maps api
//https://developers.google.com/maps/documentation/static-maps/intro
//https://github.com/kero712/Location.git