package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import static com.example.systemlife.nearbyplaces.SignUp.SHARED_PREF_NAME;

public class SingIn extends AppCompatActivity {
    AutoCompleteTextView userName;
    AutoCompleteTextView passWord;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Intent i = getIntent();

        userName = (AutoCompleteTextView) findViewById(R.id.userName);
        passWord = (AutoCompleteTextView) findViewById(R.id.passWord);
        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
                String user = sharedPreferences.getString("user", null);
                UserData userFromShared = new Gson().fromJson(user, UserData.class);

                if (String.valueOf(userName).equals(String.valueOf(userFromShared.getEmail())) &&
                        String.valueOf(passWord).equals(String.valueOf(userFromShared.getPassword()
                        ))) {
                    //Intent intent = new Intent(this, SignUp.class);
                    //startActivity(intent);
                    Toast.makeText(SingIn.this,"Welcome "+userFromShared.getUsername().toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, SignUp.class);
    }
}
//https://stackoverflow.com/questions/23005656/android-method-with-default-package-visibility-overriding-shouldnt-work-but
//https://developer.android.com/guide/practices/verifying-apps-art.html#Object_Model_Changes
//https://stackoverflow.com/questions/42944107/incorrectly-overriding-a-package
//https://developer.android.com/reference/android/graphics/PorterDuffColorFilter.html
//https://stackoverflow.com/questions/6112269/android-keep-username-in-session-until-logout
//https://developer.android.com/training/material/animations.html
//https://stackoverflow.com/questions/22192291/how-to-change-the-status-bar-color-in-android
//http://antonioleiva.com/material-design-everywhere/
//https://developer.android.com/reference/android/view/Window.html#setStatusBarColor(int)
//https://developer.android.com/reference/android/support/v4/widget/NestedScrollView.html
//http://www.devexchanges.info/2016/07/nested-scroll-views-in-android.html
