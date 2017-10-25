package com.example.systemlife.nearbyplaces.DataModels;

/**
 * Created by System.Life on 10/20/2017.
 */

public class FavModel {
    float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    String types;
    String[] photos={"photo_reference"};
}
