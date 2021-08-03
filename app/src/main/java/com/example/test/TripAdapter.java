package com.example.test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TripAdapter  extends RecyclerView.Adapter<TripAdapter.RecyclerViewHolder>{
    private static final String TAG = TripAdapter.class.getSimpleName();
    private OnClickListener onClickListener;
    private List<Trip> tripList;

    public TripAdapter(List<Trip> tripList , OnClickListener onClickListener) {
        this.tripList = tripList;
        this.onClickListener = onClickListener;
    }


    @NonNull
    @NotNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new RecyclerViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewHolder holder, int position) {
        String tripName = tripList.get(position).getTripName();
        String destination = tripList.get(position).getDestination();
        String priceRating = tripList.get(position).getPriceRating();
        String favorite = tripList.get(position).getFavorite();
        holder.getTripName().setText(tripName);
        holder.getPriceRating().setText(priceRating);
        holder.getFavorite().setActivated(true);
        holder.getDestination().setText(destination);

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

    public void setTripList(List<Trip> trips){
        tripList = trips;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private ImageView picture;
        private TextView tripName;
        private TextView destination;
        private TextView priceRating;
        private Button favorite;
        private OnClickListener onClickListener;

        public RecyclerViewHolder(@NonNull View itemView , OnClickListener onClickListener) {
            super(itemView);
            picture = itemView.findViewById(R.id.pictureView);
            tripName = itemView.findViewById(R.id.tripView);
            priceRating = itemView.findViewById(R.id.priceRatingView);
            favorite = itemView.findViewById(R.id.favoriteView);
            destination = itemView.findViewById(R.id.destinationView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            this.onClickListener = onClickListener;
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

        @Override
        public void onClick(View v) {
            onClickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            onClickListener.onItemLongClick(getAdapterPosition(), v);
            return true;
        }

//        public void setOnItemClickListener(onClickListener onClickListener) {
//            TripAdapter.onClickListener = onClickListener;
//        }

    }
    public interface OnClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}
