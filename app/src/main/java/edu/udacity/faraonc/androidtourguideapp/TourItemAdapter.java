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
 * The adapter to display tour items as a list.
 *
 * @author ConardJames
 * @version 010418-01
 */
class TourItemAdapter extends ArrayAdapter {

    /**
     * Create and adapter container tour items.
     *
     * @param context   for resource access.
     * @param tourItems the arraylist of TourItem
     */
    TourItemAdapter(Context context, ArrayList<TourItem> tourItems) {
        super(context, 0, tourItems);
    }

    @NonNull
    @Override
    /**
     * Get the view for each entry.
     *
     * @param   position    current index in the adapter.
     * @param   convertView recycled view.
     * @param   parent      contains the view.
     * @return  the view for the entry.
     */
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

    /**
     * For caching.
     */
    private class ViewHolder {
        private TextView entryName;
        private TextView entryLocation;
        private ImageView entryImage;
    }

}
