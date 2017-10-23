package com.example.systemlife.nearbyplaces.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.systemlife.nearbyplaces.DataModels.FavModel;
import com.example.systemlife.nearbyplaces.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by System.Life on 10/20/2017.
 */

public class FavAdapter extends ArrayAdapter<FavModel> {

    public FavAdapter(@NonNull Context context, @NonNull List<FavModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.fav_row,parent,false);
        }
        FavModel favModel=getItem(position);
        ImageView image=convertView.findViewById(R.id.imageView3);
        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?photoreference="+favModel.getPhotos()+"&key=AIzaSyCDSBYodVcO7O8Qaz_Fn7qU5mgDlh99Qww").into(image);

        return convertView;
    }
}
//AIzaSyCDSBYodVcO7O8Qaz_Fn7qU5mgDlh99Qww
//https://github.com/chrisjenx/Calligraphy
//https://developers.google.com/places/web-service/search
//https://developers.google.com/places/web-service/get-api-key?refresh=1
//https://developers.google.com/places/web-service/photos
//https://developers.google.com/places/web-service/autocomplete
//https://console.developers.google.com/apis/credentials/key/86?authuser=0&project=my-project-1508694435602
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=restaurant&keyword=cruise&key=AIzaSyA0lnpD55lQP6OE7UltnxNskewWcbfB4aE
//https://jsonformatter.curiousconcept.com/
