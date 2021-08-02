package com.example.test;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private ImageView picture;
    private TextView tripName;
    private TextView destination;
    private TextView priceRating;
    private Button favorite;
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        picture = itemView.findViewById(R.id.pictureView);
        tripName = itemView.findViewById(R.id.tripView);
        priceRating = itemView.findViewById(R.id.priceRatingView);
        favorite = itemView.findViewById(R.id.favoriteView);
        destination = itemView.findViewById(R.id.destinationView);
    }

    public ImageView getPicture() {
        return picture;
    }

    public TextView getTripName() {
        return tripName;
    }

    public TextView getPriceRating() {
        return priceRating;
    }

    public Button getFavorite() {
        return favorite;
    }

    public TextView getDestination() {
        return destination;
    }
}
