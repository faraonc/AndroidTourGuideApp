package edu.udacity.faraonc.androidtourguideapp;


import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The activity for a more detailed description of a tour entry.
 *
 * @author ConardJames
 * @version 010418-01
 */
public class TourActivity extends AppCompatActivity {

    final static String TOUR_KEY = "TOUR_ITEM_KEY";

    @Override
    /**
     * Create the view for the activity.
     *
     * @param   savedInstanceState  contains the saved state if not null.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_page);
        Intent intent = getIntent();
        Bundle data = getIntent().getExtras();
        final TourItem item = (TourItem) data.getParcelable(TOUR_KEY);

        /* Put the task in the MessageQueue of the UI thread for future processing to gain performance. */
        /* Setting image is expensive. */
        Handler imageHandler = new Handler(Looper.getMainLooper());
        imageHandler.post(new Runnable() {
            public void run() {
                ((ImageView) findViewById(R.id.tour_image)).setImageResource(item.getEntryImageId());
            }
        });

        ((TextView) findViewById(R.id.tour_name)).setText(item.getEntryName());
        ((TextView) findViewById(R.id.tour_address)).setText(item.getEntryLocation());
        ((TextView) findViewById(R.id.tour_description)).setText(item.getEntryDescription());
    }

}
