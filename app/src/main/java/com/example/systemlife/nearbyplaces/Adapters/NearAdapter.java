package com.example.systemlife.nearbyplaces.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.systemlife.nearbyplaces.DataModels.FavModel;
import com.example.systemlife.nearbyplaces.DataModels.NearModel;
import com.example.systemlife.nearbyplaces.R;
import com.squareup.picasso.Picasso;

/**
 * Created by System.Life on 10/20/2017.
 */

public class NearAdapter extends ArrayAdapter<NearModel> {
    private static final String TAG = NearAdapter.class.getName() ;

    public NearAdapter(@NonNull Context context, @NonNull NearModel[] objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.near_row, parent, false);
        }
        NearModel nearModel = getItem(position);
        ImageView image = (ImageView) convertView.findViewById(R.id.imageView6);
        Picasso.with(getContext()).load("https://maps.googleapis.com/maps/api/place/photo?photoreference=" + nearModel.getPhotos().get(0).getPhotoReference() + "&key=AIzaSyCDSBYodVcO7O8Qaz_Fn7qU5mgDlh99Qww").into(image);
        TextView types = (TextView) convertView.findViewById(R.id.type);

        String type="[ ";
        for (String s : nearModel.getTypes()) {
            type=type+s+" , ";
        }
        type=type+" ]";
        Log.d(TAG, "getView: "+type);
        types.setText(type);

        return convertView;
    }
}
//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=&keyword=cruise&key=AIzaSyA0lnpD55lQP6OE7UltnxNskewWcbfB4aE
//http://www.jsonschema2pojo.org/