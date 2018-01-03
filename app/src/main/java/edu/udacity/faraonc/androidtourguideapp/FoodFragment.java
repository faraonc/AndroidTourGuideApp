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
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.humba), R.drawable.humba_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.lomi), R.drawable.lomi_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.bulalo), R.drawable.bulalo_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.sinaing_na_tulingan), R.drawable.sinaing_na_tulingan_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.tinapa), R.drawable.tinapa_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.tapang_taal), R.drawable.tapang_taal_img));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
