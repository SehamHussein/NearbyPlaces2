package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    FloatingActionButton addPhoto;
    ImageView image;

    static final int REQUEST_PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        addPhoto = (FloatingActionButton) findViewById(R.id.add);
        image = (ImageView) findViewById(R.id.imageView);
        addPhoto.setOnClickListener(new View.OnClickListener()

        {
            public void onClick (View v){
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                gallery.setType("image/*");
                startActivityForResult(gallery, 1);
            }
        });
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



    public void onClick(View view) {
        Intent intent = new Intent(this, SingIn.class);
    }
}
//https://stackoverflow.com/questions/44500176/setting-up-gradle-for-api-26-android