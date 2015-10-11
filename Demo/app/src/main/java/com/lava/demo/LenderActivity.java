package com.lava.demo;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class LenderActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lender);

        if (findViewById(R.id.main_container) != null) {
            if (savedInstanceState != null) return;

            Fragment fragment = null;

            if (isRegistered()) {
                fragment = new LendMoneyListFragment();
            } else {

                fragment = new RegisterAsLenderFragment();
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, fragment).commit();
        }

        findWidgets();
    }

    private boolean isRegistered() {
        SharedPreferences sharePref = getSharedPreferences("RegisterAsLender", MODE_PRIVATE);
        return sharePref.getBoolean("isRegistered", false);
    }
    private void findWidgets() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) setupDrawerContent(navigationView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.ic_menu);
            ab.setHomeAsUpIndicator(drawable);
            ab.setDisplayHomeAsUpEnabled(true);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lender, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return false;
            }
        });
//        navigationView.setNavigationItemSelectedListener(
//                menuItem -> {
//            Fragment fragment = null;
//            switch (menuItem.getItemId()) {
//                case R.id.nav_home:
//                    fragment = new WelcomeFragment();
//
//                    break;
//                case R.id.nav_borrow:
//                    fragment = new BorrowFragment();
//                    break;
//                case R.id.nav_lend:
//                    fragment = new LendFragment();
//                    break;
//                case R.id.nav_deal:
//                    fragment = new MyDealFragment();
//                    break;
//            }
//            if (fragment != null) {
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.main_container, fragment)
//                        .addToBackStack(null)
//                        .commit();
//                getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
//            }
//            menuItem.setChecked(true);
//            mDrawerLayout.closeDrawers();
//            return true;
//
//        });
    }
}
