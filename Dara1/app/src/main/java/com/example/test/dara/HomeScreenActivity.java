package com.example.test.dara;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {

    private DrawerLayout burgerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Loading page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Setting up pager between tab fragments
        ViewPager pager = findViewById(R.id.container);
        setupPager(pager, getIntent().getExtras());
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

        // Setting up tabs
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        // Setting up hamburger
        burgerMenu = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        burgerMenu.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                burgerMenu.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupPager(ViewPager pager, Bundle bundle) {
        RolePageAdapter adapter = new RolePageAdapter(getSupportFragmentManager());
        SenderHomeFragment senderTab = new SenderHomeFragment();
        CarrierHomeFragment carrierTab = new CarrierHomeFragment();
        senderTab.setArguments(bundle);
        carrierTab.setArguments(bundle);
        adapter.addFragment(senderTab, "Sender");
        adapter.addFragment(carrierTab, "Carrier");
        pager.setAdapter(adapter);
    }
}

class RolePageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> frags = new ArrayList<>();
    private final List<String> fragNames = new ArrayList<>();

    RolePageAdapter(FragmentManager fm) {
        super(fm);
    }

    void addFragment(Fragment frag, String name) {
        frags.add(frag);
        fragNames.add(name);
    }

    public CharSequence getPageTitle(int position) {
        return fragNames.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}