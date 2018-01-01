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
        tourItems.add(new TourItem("Caleruega Church", "Nasugbo", R.drawable.ic_history_black_48dp));
        tourItems.add(new TourItem("Our Lady of Mt Carmel Church", "Lipa City", R.drawable.ic_history_black_48dp));
        tourItems.add(new TourItem("San Sebastian Cathedral", "Lipa City", R.drawable.ic_history_black_48dp));
        tourItems.add(new TourItem("Chapel on the Hill", "Batangas City", R.drawable.ic_history_black_48dp));
        tourItems.add(new TourItem("Shrine of Our Lady Of Caysasay ", "Taal", R.drawable.ic_history_black_48dp));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
