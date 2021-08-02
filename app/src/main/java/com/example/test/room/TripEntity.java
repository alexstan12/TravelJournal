package com.example.test.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Trip")
public class TripEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "picture")
    public String picture;

    @ColumnInfo(name = "tripName")
    public String tripName;

    @ColumnInfo(name = "destination")
    public String destination;

    @ColumnInfo(name = "cityBreak")
    public boolean cityBreak;

    @ColumnInfo(name = "seaSide")
    public boolean seaSide;

    @ColumnInfo(name = "mountains")
    public boolean mountains;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "startDate")
    public String startDate;

    @ColumnInfo(name = "endDate")
    public String endDate;

    @ColumnInfo(name ="rating")
    public float rating;

    public TripEntity(String picture, String tripName, String destination, boolean cityBreak, boolean seaSide, boolean mountains, int price, String startDate, String endDate, float rating) {
        this.picture = picture;
        this.tripName = tripName;
        this.destination = destination;
        this.cityBreak = cityBreak;
        this.seaSide = seaSide;
        this.mountains = mountains;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "TripEntity{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", tripName='" + tripName + '\'' +
                ", destination='" + destination + '\'' +
                ", cityBreak=" + cityBreak +
                ", seaSide=" + seaSide +
                ", mountains=" + mountains +
                ", price=" + price +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", rating=" + rating +
                '}';
    }
}
