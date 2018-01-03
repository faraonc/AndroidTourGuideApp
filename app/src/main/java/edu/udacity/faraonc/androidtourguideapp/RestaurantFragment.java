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
public class RestaurantFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.little_white_cottage), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.butch_seafood_grill), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.rose_grace_restaurant), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.chez_deo_ristorante_italiano), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.liam_lomi_house), R.drawable.ic_beach_black_48dp));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }
}
