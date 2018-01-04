package edu.udacity.faraonc.androidtourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 */
public class MountainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.mt_batulao), R.drawable.mt_batulao_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.mt_maculot), R.drawable.mt_maculot_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.mt_salvacion), R.drawable.mt_salvacion_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.manabu_peak), R.drawable.mt_manabu_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.mt_talamitam), R.drawable.mt_talamitam_img));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), TourActivity.class);
                intent.putExtra(TourActivity.TOUR_KEY, ((TourItem) adapterView.getItemAtPosition(i)));
                startActivity(intent);
            }
        });
        return rootView;
    }
}
