package com.example.test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TripAdapter  extends RecyclerView.Adapter<RecyclerViewHolder>{
    private static final String TAG = TripAdapter.class.getSimpleName();
    private List<Trip> tripList;
    public TripAdapter(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewHolder holder, int position) {
        String tripName = tripList.get(position).getTripName();
        String priceRating = tripList.get(position).getPriceRating();
        String favorite = tripList.get(position).getFavorite();
        holder.getTripName().setText(tripName);
        holder.getPriceRating().setText(priceRating);
        holder.getFavorite().setText(favorite);

        if (position == 0) {
            holder.getPicture().setImageResource(R.drawable.ic_launcher_foreground);
        }

        holder.getPicture().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "POSITION CLICK: text= " + tripName + " position= " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }
}
