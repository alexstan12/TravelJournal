package com.example.test.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.test.Trip;

import java.util.List;

public class TripRepository {

    private TripDao tripDao;

    private LiveData<List<Trip>> allTrips;

    public TripRepository(Application application){
        TripRoomDatabase db = TripRoomDatabase.getDatabase(application);
        tripDao = db.tripDao();
        allTrips = tripDao.getTripList();
    }

    public LiveData<List<Trip>> getAllTrips(){
        return allTrips;
    }

    public void insert(TripEntity trip) {
        TripRoomDatabase.executor.execute(() -> {
            tripDao.insertTrip(trip);
        });
    }
    public void update(TripEntity trip) {
        TripRoomDatabase.executor.execute(() -> {
            tripDao.updateTrip(trip);
        });
    }
}
