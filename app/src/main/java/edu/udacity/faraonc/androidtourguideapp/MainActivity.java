package edu.udacity.faraonc.androidtourguideapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final static int HOME = 0;

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
        onNavigationItemSelected(navigationView.getMenu().getItem(HOME).setChecked(true));
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.batangas));

        } else if (id == R.id.nav_natures) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new NatureFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.natures));

        } else if (id == R.id.nav_landmarks) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LandmarkFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.landmarks));

        } else if (id == R.id.nav_museums) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MuseumFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.museums));

        } else if (id == R.id.nav_cuisines) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CuisineFragment())
                    .commit();
            getSupportActionBar().setTitle(getString(R.string.cuisines));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
