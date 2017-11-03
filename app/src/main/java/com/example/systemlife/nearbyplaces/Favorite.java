package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import static com.example.systemlife.nearbyplaces.SignUp.SHARED_PREF_NAME;

public class Favorite extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        Intent i=getIntent();

        list=(ListView) findViewById(R.id.favlist);
        ImageView log = (ImageView) findViewById(R.id.logout_);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("email");
                editor.remove("password");
                editor.remove("birthdate");
                editor.remove("username");
                editor.apply();
                Intent intent = new Intent(Favorite.this, SingIn.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
