package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

public class SignUp extends AppCompatActivity {
    FloatingActionButton addPhoto;
    ImageView image;
    AutoCompleteTextView fullName;
    AutoCompleteTextView email;
    AutoCompleteTextView pass;
    AutoCompleteTextView birthDate;
    Button signUp;

    static final int REQUEST_PICK_IMAGE = 1;
    //protected static final SharedPreferences settings = null;
    static final String SHARED_PREF_NAME="user";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(imageBitmap);
        } else {
            Toast.makeText(this, "you didn't pick a picture", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Intent i = getIntent();

        addPhoto = (FloatingActionButton) findViewById(R.id.add);
        image = (ImageView) findViewById(R.id.imageView);
        addPhoto.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                gallery.setType("image/*");
                startActivityForResult(gallery, 1);
            }
        });

        fullName = (AutoCompleteTextView) findViewById(R.id.fullName);
        email = (AutoCompleteTextView) findViewById(R.id.email);
        pass = (AutoCompleteTextView) findViewById(R.id.pass);
        birthDate = (AutoCompleteTextView) findViewById(R.id.birthDate);
        signUp = (Button) findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                SharedPreferences.Editor editor = settings.edit();
//                editor.putString("username", String.valueOf(fullName));
//                editor.putString("password",String.valueOf(pass));
//                editor.putString("email",String.valueOf(email));
//                editor.putString("birthdate",String.valueOf(birthDate));
//                editor.putString("image",String.valueOf(image));

                UserData userData = new UserData(String.valueOf(fullName), String.valueOf(pass), String.valueOf(email));
                String userDataToGson = new Gson().toJson(userData);
                SharedPreferences  sharedPreferences= getSharedPreferences(SHARED_PREF_NAME,0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("userData",userDataToGson);
                editor.apply();
                //Intent intent2=new Intent(getApplicationContext(),Customer.class);
                //startActivity(intent2);
                //https://stackoverflow.com/questions/6112269/android-keep-username-in-session-until-logout
            }
        });


    }


    public void onClick(View view) {
        Intent intent = new Intent(this, SingIn.class);
        startActivity(intent);
    }
}
//https://stackoverflow.com/questions/44500176/setting-up-gradle-for-api-26-android