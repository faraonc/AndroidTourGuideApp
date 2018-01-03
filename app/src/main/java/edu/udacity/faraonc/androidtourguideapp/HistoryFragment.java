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
public class HistoryFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.museo_leon_at_apacible), R.drawable.museo_leon_apacible_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.museo_marino_at_agoncillo), R.drawable.museo_marino_agoncillo_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.museo_malvar), R.drawable.museo_malvar_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.ez_museum), R.drawable.ez_museum_img));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
