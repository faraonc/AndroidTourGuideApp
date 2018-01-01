package edu.udacity.faraonc.androidtourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by faraonc on 12/31/17.
 */

class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;
    private int numberCategories;
    private CategoryTypeEnum type;

    enum CategoryTypeEnum{
        NATURES,
        LANDMARKS,
        MUSEUMS, //TODO
        CUISINES
    }

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm, CategoryTypeEnum type) {
        super(fm);
        this.context = context;
        this.type = type;

        switch(this.type){
            case NATURES:
                this.numberCategories = 3;
                break;

            case LANDMARKS:
                this.numberCategories = 3;
                break;

            case CUISINES:
        }
    }


    @Override
    public Fragment getItem(int position) {
        switch(this.type){
            case NATURES:
                return getNatureItem(position);

            case LANDMARKS:
                return getLandmarkItem(position);

            case CUISINES:
                return getNatureItem(position); //TODO
        }
        return null;
    }

    private Fragment getNatureItem(int position){
        switch(position){
            case 0:
                return new BeachFragment();
            case 1:
                return new MountainFragment();
            case 2:
                return new IslandFragment();
        }
        return null;
    }

    private Fragment getLandmarkItem(int position){
        switch(position){
            case 0:
                return new ChurchFragment();
            case 1:
                return new FarmFragment();
            case 2:
                return new IslandFragment();
        }
        return null;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return this.numberCategories;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        switch(this.type){
            case NATURES:
                return getNaturePageTitle(position);

            case LANDMARKS:
                return getLandmarkPageTitle(position); //TODO

            case CUISINES:
                return getNaturePageTitle(position); //TODO
        }
        return null;
    }

    private CharSequence getNaturePageTitle(int position){
        // Generate title based on item position
        switch (position) {
            case 0:
                return this.context.getString(R.string.beaches);

            case 1:
                return this.context.getString(R.string.mountains);

            case 2:
                return this.context.getString(R.string.islands);
        }
        return null;
    }

    private CharSequence getLandmarkPageTitle(int position){
        // Generate title based on item position
        switch (position) {
            case 0:
                return this.context.getString(R.string.churches);

            case 1:
                return this.context.getString(R.string.farms);

            case 2:
                return this.context.getString(R.string.lighthouses);
        }
        return null;
    }
}
