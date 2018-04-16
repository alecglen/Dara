package com.example.test.dara;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        ViewPager pager = findViewById(R.id.tutorial_viewpager);
        setupPager(pager);
        TabLayout tabLayout = findViewById(R.id.tutorial_tabs);
        tabLayout.setupWithViewPager(pager, true);

        // Make button to skip ahead
        Button newUser = findViewById(R.id.skip_button);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(TutorialActivity.this, HomeScreenActivity.class);
                TutorialActivity.this.startActivity(myIntent);

            }});
    }

    private void setupPager(ViewPager pager) {
        TutorialPageAdapter adapter = new TutorialPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tutorial1Fragment(), "Tutorial Page 1");
        adapter.addFragment(new Tutorial2Fragment(), "Tutorial Page 2");
        adapter.addFragment(new Tutorial3Fragment(), "Tutorial Page 3");
        adapter.addFragment(new Tutorial4Fragment(), "Tutorial Page 4");
        adapter.addFragment(new Tutorial5Fragment(), "Tutorial Page 5");
        adapter.addFragment(new Tutorial6Fragment(), "Tutorial Page 6");
        adapter.addFragment(new Tutorial7Fragment(), "Tutorial Page 7");
        pager.setAdapter(adapter);
    }
}

class TutorialPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> frags = new ArrayList<>();
    private final List<String> fragNames = new ArrayList<>();

    TutorialPageAdapter(FragmentManager fm) {
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