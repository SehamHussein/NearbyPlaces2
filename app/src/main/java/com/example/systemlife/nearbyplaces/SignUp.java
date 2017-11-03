package com.example.systemlife.nearbyplaces;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.example.systemlife.nearbyplaces.R.id.imageView;

public class SignUp extends AppCompatActivity {
    FloatingActionButton addPhoto;
    ImageView image;
    EditText fullName;
    EditText email;
    EditText pass;
    EditText birthDate;
    Button signUp;

    Calendar myCalendar;
    static final int REQUEST_PICK_IMAGE = 1;
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
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_PICK_IMAGE) {
            Uri imageUri = data.getData();
            image.setImageURI(imageUri);
            addPhoto.hide();
        }
        else Toast.makeText(this, "you didn't pick a picture", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Intent i = getIntent();

        addPhoto = (FloatingActionButton) findViewById(R.id.add);
        image = (ImageView) findViewById(imageView);
        addPhoto.setOnClickListener(new View.OnClickListener()

        {
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, REQUEST_PICK_IMAGE);
            }
        });

        fullName = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        myCalendar = Calendar.getInstance();
        birthDate = (EditText) findViewById(R.id.birthDate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        birthDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SignUp.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        signUp = (Button) findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidEmail(email.getText().toString())) {
                    SharedPreferences prefs = getSharedPreferences(SHARED_PREF_NAME, 0);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("username", fullName.getText().toString());
                    editor.putString("password", pass.getText().toString());
                    editor.putString("email", email.getText().toString());
                    editor.putString("birthdate", birthDate.getText().toString());
                    editor.apply();
                    Toast.makeText(SignUp.this, "welcome " + prefs.getString("username", "no data"), Toast.LENGTH_SHORT).show();
                    prefs.getString("username", "no data");
                    Intent intent = new Intent(SignUp.this, Search.class);
                    startActivity(intent);
                    finish();
                } else email.setError("the E-mail is not valid");
            }
        });
    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthDate.setText(sdf.format(myCalendar.getTime()));
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
//https://stackoverflow.com/questions/14933330/datepicker-how-to-popup-datepicker-when-click-on-edittext