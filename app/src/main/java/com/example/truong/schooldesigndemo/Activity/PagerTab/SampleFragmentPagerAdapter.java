package com.example.truong.schooldesigndemo.Activity.PagerTab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.truong.schooldesigndemo.CustomView.PagerSlidingTabStrip;
import com.example.truong.schooldesigndemo.R;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 3;
    private int tabIcons[] = {R.drawable.ic_home, R.drawable.ic_notification, R.drawable.ic_more};

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}