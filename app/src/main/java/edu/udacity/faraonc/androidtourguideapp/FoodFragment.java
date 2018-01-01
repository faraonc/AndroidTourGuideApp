package edu.udacity.faraonc.androidtourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem("Humba", "Batangas City", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Lomi", "Batangas City", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Bulalo", "Sto. Tomas", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Sinaing na Tulingan", "Balayan", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Tinapa", "Lemery", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Tapang Taal", "Taal", R.drawable.ic_beach_black_48dp));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
