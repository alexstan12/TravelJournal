package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.slider.Slider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTripActivity extends FragmentActivity {

    public static final String TRIP_NAME = "trip_name";
    public static final String DESTINATION = "destination";
    public static final String CITY_BREAK = "city_break";
    public static final String TRIP_TYPE = "trip_type";
    public static final String SEA_SIDE = "sea_side";
    public static final String MOUNTAINS = "mountains";
    public static final String PRICE = "price";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String RATING = "rating";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dialog);

         EditText tripName = findViewById(R.id.trip_name);
         EditText destination = findViewById(R.id.destination);
//    private RadioButton cityBreak  =findViewById(R.id.city_break);
//    private RadioButton seaSide  =findViewById(R.id.sea_side);
//    private RadioButton mountains  =findViewById(R.id.mountains);
         RadioGroup tripType = findViewById(R.id.trip_type);
         Slider price = findViewById(R.id.price);
         DatePicker startDate = findViewById(R.id.start_date);
         DatePicker endDate = findViewById(R.id.end_date);
         RatingBar rating = findViewById(R.id.rating);

        RatingBar ratingBar = findViewById(R.id.rating);
        ratingBar.setMax(5);
        ratingBar.setNumStars(5);
        ratingBar.setRating(3);

        Button saveButton = findViewById(R.id.saveData);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent reply = new Intent();
                if (TextUtils.isEmpty(tripName.getText())
                    || TextUtils.isEmpty(destination.getText())){
                    setResult(RESULT_CANCELED,reply);
                }else {
                    Bundle bundle = new Bundle();
                    bundle.putString(TRIP_NAME, tripName.getText().toString());
                    bundle.putString(DESTINATION, destination.getText().toString());
                    bundle.putInt(TRIP_TYPE, tripType.getCheckedRadioButtonId());
                    bundle.putFloat(PRICE, price.getValue());
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                    dateFormat.format(new Date())
//                    bundle.putString(START_DATE, startDate.ge);
                    bundle.putFloat(RATING, rating.getRating());
                    reply.putExtra("TRIP_BUNDLE",bundle);

                    setResult(RESULT_OK, reply);
                }
                finish();
            }
        });
    }
}
