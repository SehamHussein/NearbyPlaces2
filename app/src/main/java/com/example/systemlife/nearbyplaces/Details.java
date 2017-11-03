package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.systemlife.nearbyplaces.DataModels.NearModel;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent=getIntent();
        final NearModel nearModel=(NearModel) getIntent().getSerializableExtra("nearModels");
        TextView category=(TextView)findViewById(R.id.textView10);
        TextView name=(TextView)findViewById(R.id.textView9);
        TextView open=(TextView)findViewById(R.id.textView13);
        TextView rate=(TextView)findViewById(R.id.textView15);
        ImageView imageView=(ImageView)findViewById(R.id.imageView7);
        RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar3);

        name.setText(nearModel.getName());
        category.setText((CharSequence) nearModel.getTypes());
        open.setText((CharSequence) nearModel.getOpeningHours());
        float rating= (float) nearModel.getRating().floatValue();
        ratingBar.setRating(rating);
        Picasso.with(getBaseContext()).load("https://maps.googleapis.com/maps/api/place/photo?photoreference="+nearModel.getReference()+"&key=AIzaSyCDSBYodVcO7O8Qaz_Fn7qU5mgDlh99Qww").into(imageView);

        ImageView fav=(ImageView)findViewById(R.id.imageView9);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
//AIzaSyCpTTibaozd7unbZKJtBjIIubWr5C_2iYo
//static maps api
//https://developers.google.com/maps/documentation/static-maps/intro
//https://github.com/kero712/Location.git