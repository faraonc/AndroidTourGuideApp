package edu.udacity.faraonc.androidtourguideapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static int HOME = 0;
    private final static int NATURE = 1;
    private final static int LANDMARK = 2;
    private final static int MUSEUM = 3;
    private final static int CUISINE = 4;
    private int drawerState = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            onNavigationItemSelected(navigationView.getMenu().getItem(HOME).setChecked(true));
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Make sure to call the super method so that the states of our views are saved
        super.onSaveInstanceState(outState);
        // Save our own state now
        outState.putInt(getString(R.string.drawer_state_key), this.drawerState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            this.drawerState = savedInstanceState.getInt(getString(R.string.drawer_state_key), 0);
            String tag = getString(R.string.home_tag);
            switch (this.drawerState) {
                case NATURE:
                    tag = getString(R.string.nature_tag);
                    break;
                case LANDMARK:
                    tag = getString(R.string.landmark_tag);
                    break;
                case MUSEUM:
                    tag = getString(R.string.museum_tag);
                    break;
                case CUISINE:
                    tag = getString(R.string.cuisine_tag);
                    break;
                default:
                    tag = getString(R.string.home_tag);


            }
            getSupportFragmentManager().findFragmentByTag(tag);
        }

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            this.drawerState = HOME;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment(), getString(R.string.home_tag))
                    .commit();

        } else if (id == R.id.nav_natures) {
            this.drawerState = NATURE;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new NatureFragment(), getString(R.string.nature_tag))
                    .addToBackStack(getString(R.string.natures))
                    .commit();

        } else if (id == R.id.nav_landmarks) {
            this.drawerState = LANDMARK;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LandmarkFragment(), getString(R.string.landmark_tag))
                    .addToBackStack(getString(R.string.landmarks))
                    .commit();

        } else if (id == R.id.nav_museums) {
            this.drawerState = MUSEUM;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MuseumFragment(), getString(R.string.museum_tag))
                    .addToBackStack(getString(R.string.museums))
                    .commit();
        } else if (id == R.id.nav_cuisines) {
            this.drawerState = CUISINE;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CuisineFragment(), getString(R.string.cuisine_tag))
                    .addToBackStack(getString(R.string.cuisines))
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
