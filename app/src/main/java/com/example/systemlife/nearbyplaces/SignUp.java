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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

public class SignUp extends AppCompatActivity {
    FloatingActionButton addPhoto;
    ImageView image;
    EditText fullName;
    EditText email;
    EditText pass;
    EditText birthDate;
    Button signUp;

    static final int REQUEST_PICK_IMAGE = 1;
    //protected static final SharedPreferences settings = null;
    static final String SHARED_PREF_NAME = "user";

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

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
                Intent gallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                gallery.setType("image/*");
                startActivityForResult(gallery, 1);
            }
        });

        fullName = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        birthDate = (EditText) findViewById(R.id.birthDate);
        signUp = (Button) findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences(SHARED_PREF_NAME, 0);
                SharedPreferences.Editor editor = prefs.edit();
//                editor.putString("username",fullName.getText().toString());
//                editor.putString("password",pass.getText().toString());
//                editor.putString("email",email.getText().toString());
//                editor.putString("birthdate",birthDate.getText().toString());
//                editor.apply();
                editor.putString("username", fullName.getText().toString());
                editor.putString("password", pass.getText().toString());
                editor.putString("email", email.getText().toString());
                editor.putString("birthdate", birthDate.getText().toString());
                editor.apply();
                //editor.putString("image",String.valueOf(image));
                Toast.makeText(SignUp.this, "welcom " + prefs.getString("username", "no data"), Toast.LENGTH_SHORT).show();
                prefs.getString("username", "no data");

//                if (isValidEmail(email.getText().toString())) {
//                    UserData userData = new UserData(String.valueOf(fullName), String.valueOf(pass), String.valueOf(email));
//                    String userDataToGson = new Gson().toJson(userData);
//                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    Toast.makeText(SignUp.this, userDataToGson, Toast.LENGTH_LONG).show();
//                    editor.putString("userData", userDataToGson);
//                    editor.apply();
                Intent intent = new Intent(SignUp.this, Search.class);
                startActivity(intent);
                finish();
//                    //Intent intent2=new Intent(getApplicationContext(),Customer.class);
//                    //startActivity(intent2);
//                    //https://stackoverflow.com/questions/6112269/android-keep-username-in-session-until-logout
//                } else email.setError("the E-mail is not valid");
            }
        });
    }

    public void onClick(View view) {
        Intent intent2 = new Intent(SignUp.this, SingIn.class);
        startActivity(intent2);
        finish();
    }
}
//https://stackoverflow.com/questions/44500176/setting-up-gradle-for-api-26-android
//TextInputLayout
//toolbar as action bar android
