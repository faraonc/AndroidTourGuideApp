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
public class SpecialtyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.apolinario_mabini_shrine), R.drawable.apolinario_mabini_shrine_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.casa_de_segunda), R.drawable.casa_de_segunda_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.museo_ng_katipunan), R.drawable.museo_katipunan_img  ));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        return rootView;
    }

}
