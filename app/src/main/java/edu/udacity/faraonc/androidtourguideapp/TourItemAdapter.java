package edu.udacity.faraonc.androidtourguideapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ConardJames on 12/31/2017.
 */

class TourItemAdapter extends ArrayAdapter {

    TourItemAdapter(Context context, ArrayList<TourItem> tourItems) {
        super(context, 0, tourItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_entry, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.entryName = (TextView) listItemView.findViewById(R.id.list_entry_name_textview);
            viewHolder.entryLocation = (TextView) listItemView.findViewById(R.id.list_entry_location_textview);
            viewHolder.entryImage = (ImageView) listItemView.findViewById(R.id.list_entry_imageview);
            listItemView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) listItemView.getTag();
        final TourItem item = (TourItem) getItem(position);
        viewHolder.entryName.setText(item.getEntryName());
        viewHolder.entryLocation.setText(item.getEntryLocation());

        /* Put the task in the MessageQueue of the UI thread for future processing to gain performance. */
        /* Setting image is expensive. */
        Handler imageHandler = new Handler(Looper.getMainLooper());
        imageHandler.post(new Runnable() {
            public void run() {
                viewHolder.entryImage.setBackgroundResource(item.getEntryImageId());
            }
        });

        return listItemView;
    }

    private class ViewHolder {
        private TextView entryName;
        private TextView entryLocation;
        private ImageView entryImage;
    }

}
