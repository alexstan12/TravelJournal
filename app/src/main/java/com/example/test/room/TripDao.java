package com.example.test.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.test.Trip;

import java.util.List;

@Dao
public abstract class TripDao {

//    @Query("SELECT * FROM Trip")
//    public abstract List<TripEntity> getTripList();

    @Insert
    public abstract void insertTrip(TripEntity trip);

    @Query("DELETE FROM Trip")
    public abstract void deleteAll();

    @Delete
    public abstract void delete(TripEntity trip);

    @Query("SELECT * from Trip")
    abstract LiveData<List<Trip>> getTripList();
}
