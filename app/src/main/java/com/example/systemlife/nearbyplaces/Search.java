package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.example.systemlife.nearbyplaces.DataModels.FavModel;

import java.util.List;

public class Search extends AppCompatActivity {
ListView fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent i=getIntent();
        Intent i2=getIntent();
        fav=(ListView) findViewById(R.id.listView);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.log_out , menu);
        return true;
    }
}
