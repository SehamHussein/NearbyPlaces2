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

import com.example.systemlife.nearbyplaces.DataModels.FavModel;
import com.example.systemlife.nearbyplaces.DataModels.NearModel;
import com.example.systemlife.nearbyplaces.R;
import com.squareup.picasso.Picasso;

/**
 * Created by System.Life on 10/20/2017.
 */

public class NearAdapter extends ArrayAdapter<NearModel> {
    public NearAdapter(@NonNull Context context, @NonNull NearModel[] objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.near_row,parent,false);
        }
        NearModel nearModel=getItem(position);
        ImageView image=convertView.findViewById(R.id.imageView6);
        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?photoreference="+nearModel.getPhotos()+"&key=AIzaSyCDSBYodVcO7O8Qaz_Fn7qU5mgDlh99Qww").into(image);


        return convertView;
    }
}
