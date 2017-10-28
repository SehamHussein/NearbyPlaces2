package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.regex.Pattern;

import static com.example.systemlife.nearbyplaces.SignUp.SHARED_PREF_NAME;

public class SingIn extends AppCompatActivity {
    EditText userName;
    EditText passWord;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Intent i = getIntent();
        Intent i2=getIntent();

        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
        final String user = sharedPreferences.getString("email", null);
        final String pw=sharedPreferences.getString("password", null);

        if (!(user==null)) {
            Intent intent = new Intent(this, Search.class);
            startActivity(intent);
            finish();
        }
        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        signIn = (Button) findViewById(R.id.signIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userName.getText().toString().equals(user) &&
                        passWord.getText().toString().equals(pw))
                {
                    Intent intent = new Intent(SingIn.this, Search.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(SingIn.this, "Welcome " + sharedPreferences.getString("username","no data"), Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(SingIn.this, "you are not sign up", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onClick2(View view) {
        Intent intent2 = new Intent(SingIn.this, SignUp.class);
        startActivity(intent2);
        finish();
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
