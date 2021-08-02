package com.example.test.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TripEntity.class}, version = 2)
public abstract class TripRoomDatabase extends RoomDatabase {

    public abstract TripDao tripDao();

    private static volatile TripRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TripRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null){
            synchronized(TripRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE  = Room.databaseBuilder(context.getApplicationContext(),
                            TripRoomDatabase.class, "trip_database")
//                            .addMigrations(MIGRATION1_2)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

//    static final Migration MIGRATION1_2 = new Migration(1, 2) {
//
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("SELECT CONVERT(varchar(10), price) FROM Trip");
//        }
//    };
}
