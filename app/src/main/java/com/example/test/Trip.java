package com.example.test;

import java.io.Serializable;

public class Trip implements Serializable {

    private String picture;
    private String tripName;
    private String priceRating;
    private String favorite;

    public Trip(String picture, String tripName, String priceRating, String favorite) {
        this.picture = picture;
        this.tripName = tripName;
        this.priceRating = priceRating;
        this.favorite = favorite;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(String priceRating) {
        this.priceRating = priceRating;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
