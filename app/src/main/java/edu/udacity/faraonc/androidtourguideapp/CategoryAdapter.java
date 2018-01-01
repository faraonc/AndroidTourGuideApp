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
        MUSEUMS,
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

            case MUSEUMS:
                this.numberCategories = 3;
                break;

            case CUISINES:
                this.numberCategories = 2;
        }
    }


    @Override
    public Fragment getItem(int position) {
        switch(this.type){
            case NATURES:
                return getNatureItem(position);

            case LANDMARKS:
                return getLandmarkItem(position);

            case MUSEUMS:
                return getMuseumItem(position);

            case CUISINES:
                return getCuisineItem(position);
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
                return new LighthouseFragment();
        }
        return null;
    }

    private Fragment getMuseumItem(int position){
        switch(position){
            case 0:
                return new HistoryFragment();
            case 1:
                return new SpecialtyFragment();
            case 2:
                return new ArtFragment();
        }
        return null;
    }

    private Fragment getCuisineItem(int position){
        switch(position){
            case 0:
                return new RestaurantFragment();
            case 1:
                return new FoodFragment();
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
                return getLandmarkPageTitle(position);

            case MUSEUMS:
                return getMuseumPageTitle(position);

            case CUISINES:
                return getCuisinePageTitle(position);
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

    private CharSequence getMuseumPageTitle(int position){
        // Generate title based on item position
        switch (position) {
            case 0:
                return this.context.getString(R.string.history);

            case 1:
                return this.context.getString(R.string.specialty);

            case 2:
                return this.context.getString(R.string.art);
        }
        return null;
    }

    private CharSequence getCuisinePageTitle(int position){
        // Generate title based on item position
        switch (position) {
            case 0:
                return this.context.getString(R.string.restaurants);

            case 1:
                return this.context.getString(R.string.foods);
        }
        return null;
    }
}
