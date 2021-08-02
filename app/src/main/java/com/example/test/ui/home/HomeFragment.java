package com.example.test.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.AddTripActivity;
import com.example.test.R;
import com.example.test.Trip;
import com.example.test.TripAdapter;

import com.example.test.databinding.FragmentHomeBinding;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    private final String TAG = HomeFragment.class.getSimpleName();
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public static final int NEW_TRIP_ACTIVITY_REQUEST_CODE = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        try {
            homeViewModel =
                    new ViewModelProvider(this).get(HomeViewModel.class);
//                new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(HomeViewModel.class);
//        }catch(Exception e){
//            Log.d("ERROR_ALEX","ERROR ON INITIALIZING homeViewModel");
//        }
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recycler = binding.recyclerview;
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Trip> tripList = new ArrayList<>();
        Trip trip1 = new Trip("picture", "tripName", "priceRating", "favorite");
        tripList.add(trip1);
        TripAdapter tripAdapter = new TripAdapter(tripList);
        recycler.setAdapter(tripAdapter);

        final TextView textView = binding.textHome;
        homeViewModel.getAllTrips().observe(getViewLifecycleOwner(), new Observer<List<Trip>>() {
            @Override
            public void onChanged(List<Trip> trips) {
                tripAdapter.setTripList(trips);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "HA, YOU DID IT!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getContext(), AddTripActivity.class);
                startActivityForResult(intent, NEW_TRIP_ACTIVITY_REQUEST_CODE);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TRIP_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Trip trip = new Trip("placeholder",
                    data.getBundleExtra("TRIP_BUNDLE").getString(AddTripActivity.TRIP_NAME),
                    data.getBundleExtra("TRIP_BUNDLE").getString(AddTripActivity.PRICE),
                    "favorite")
                    ;
            homeViewModel.insert(trip);
        }
    }
}