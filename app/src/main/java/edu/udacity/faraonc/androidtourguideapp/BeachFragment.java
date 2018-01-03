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
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.masasa_beach), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.playa_laiya), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.matabungkay_beach), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.burot_beach), R.drawable.ic_beach_black_48dp));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.natipunan_beach), R.drawable.ic_beach_black_48dp));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
