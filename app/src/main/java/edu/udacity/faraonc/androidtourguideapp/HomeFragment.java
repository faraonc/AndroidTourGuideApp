package edu.udacity.faraonc.androidtourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * The fragment for home page.
 *
 * @author ConardJames
 * @version 010418-01
 */
public class HomeFragment extends Fragment {

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
        View rootView = inflater.inflate(R.layout.category_home_layout, container, false);
        return rootView;
    }

}
