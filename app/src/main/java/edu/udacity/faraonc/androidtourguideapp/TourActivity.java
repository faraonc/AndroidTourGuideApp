package edu.udacity.faraonc.androidtourguideapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TourActivity extends AppCompatActivity {

    final static String TOUR_KEY = "TOUR_ITEM_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_page);
        Intent intent = getIntent();
        Bundle data = getIntent().getExtras();
        final TourItem item = (TourItem) data.getParcelable(TOUR_KEY);

        Handler imageHandler = new Handler(Looper.getMainLooper());
        imageHandler.post(new Runnable() {
            public void run() {
                ((ImageView)findViewById(R.id.tour_image)).setImageResource(item.getEntryImageId());
            }
        });

        ((TextView)findViewById(R.id.tour_name)).setText(item.getEntryName());
        ((TextView)findViewById(R.id.tour_address)).setText(item.getEntryLocation());
        ((TextView)findViewById(R.id.tour_description)).setText(item.getEntryDescription());

    }
}
