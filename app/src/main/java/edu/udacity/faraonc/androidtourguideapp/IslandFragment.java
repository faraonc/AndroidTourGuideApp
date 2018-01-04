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
 * The fragment for island.
 *
 * @author ConardJames
 * @version 010418-01
 */
public class IslandFragment extends Fragment {

    @Override
    /**
     * Create the view for the fragment.
     *
     * @param   inflater    for creating the view
     * @param   container   contains the view.
     * @param   savedInstanceState  contains the saved state if not null.
     * @return the view for the entry.
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<TourItem> tourItems = new ArrayList<>();
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.fortune_island), R.drawable.fortune_island_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.sombrero_island), R.drawable.sombrero_island_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.isla_verde), R.drawable.isla_verde_img));
        tourItems.add(new TourItem(getActivity().getResources().getStringArray(R.array.lunod_island), R.drawable.lunod_island_img));

        TourItemAdapter itemsAdapter = new TourItemAdapter(getActivity(), tourItems);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            /**
             * Launch the activity to display tour item.
             *
             * @param   adapterView contains the TourItem.
             * @param   view        the view that holds the current list entry.
             * @param   i           position in the adapter.
             * @param   l           the id.
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), TourActivity.class);
                intent.putExtra(TourActivity.TOUR_KEY, ((TourItem) adapterView.getItemAtPosition(i)));
                startActivity(intent);
            }
        });
        return rootView;
    }

}
