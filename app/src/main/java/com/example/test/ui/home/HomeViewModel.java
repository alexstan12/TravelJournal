package com.example.test.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.Trip;
import com.example.test.room.TripRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private TripRepository tripRepository;
    private LiveData<List<Trip>> allTrips;

    public HomeViewModel(Application application) {
        super(application);
        tripRepository = new TripRepository(application);
        allTrips = tripRepository.getAllTrips();
    }

    public LiveData<List<Trip>> getAllTrips() {
        return allTrips;
    }
    public void insert(Trip trip) { tripRepository.insert(trip); }
}