package com.example.iit.androidnewsappspl2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /// private  int numOfPages = 4; //viewpager has 4 pages
    ArrayList<String>categoryTitle=new ArrayList<String>();
    //private  String[] pageTitle = {"Food", "Movie", "Shopping","travel"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        categoryTitle=getPageTitle();
        for (int i = 0; i < categoryTitle.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(categoryTitle.get(i)));
        }

        //set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(),categoryTitle);
        //tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(onTabSelectedListener(viewPager));
    }

    private TabLayout.OnTabSelectedListener onTabSelectedListener(final ViewPager pager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }
    public ArrayList<String> getPageTitle() {
        categoryTitle.add("source");
        categoryTitle.add("top-headline");
        categoryTitle.add("business");
        categoryTitle.add("sports");
        categoryTitle.add("entertainment");
        categoryTitle.add("health");
        categoryTitle.add("technology");
        categoryTitle.add("science");
        //categoryTitle.add("movie");
        /*categoryTitle.add("shopping");
        categoryTitle.add("travel");
        categoryTitle.add("hi");
        categoryTitle.add("I");
        categoryTitle.add("Am");
        categoryTitle.add("Obaidur");*/
        return categoryTitle;
    }
}