package edu.udacity.faraonc.androidtourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeachFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem("Masasa Beach", "Batangas City", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Playa Laiya", "San Juan", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Matabungkay Beach", "Batangas City", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Burot Beach", "Calatagan", R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem("Natipunan Beach", "Nasugbo", R.drawable.ic_beach_black_48dp));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
