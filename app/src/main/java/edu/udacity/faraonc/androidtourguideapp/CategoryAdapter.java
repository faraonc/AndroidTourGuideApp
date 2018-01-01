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
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

        } else if (position == 1) {

        } else if (position == 2) {

        } else {

        }

        return null;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:

            case 1:

            case 2:

            case 3:

            default:
                return null;
        }
    }
}
