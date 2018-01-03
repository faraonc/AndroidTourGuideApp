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
public class ChurchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.caleruega_church), R.drawable.caleruega_church_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.mt_carmel_church), R.drawable.mt_carmel_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.san_sebastian_cathedral), R.drawable.san_sebastian_church_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.chapel_on_the_hill), R.drawable.chapel_on_the_hill_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.lady_of_casaysay), R.drawable.lady_caysasay_img));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
