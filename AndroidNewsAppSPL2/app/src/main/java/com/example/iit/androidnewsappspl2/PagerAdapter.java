package com.example.iit.androidnewsappspl2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    ArrayList<String>categoryTitle=new ArrayList<String>();

    public PagerAdapter(FragmentManager fm, int numOfTabs, ArrayList<String>categoryTitle) {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.categoryTitle=categoryTitle;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0: return TabFragmentNewsSource.getInstance(position);
                  //return TabFragment.getInstance(position, categoryTitle.get(position));
            case 1: return TabFragmentTopStories.getInstance(position);

            default:// return TabFragment.getInstance(position);
                     return TabFragment.getInstance(position, categoryTitle.get(position));

        }
        //return TabFragmentNewsSource.getInstance(position);
        //return t.getInstance(position);
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}