package com.example.truong.schooldesigndemo.Activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.truong.schooldesigndemo.Activity.PagerTab.PageFragment;
import com.example.truong.schooldesigndemo.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends CommonActivity {
    private TabLayout tabLayout;
    private static final String TAG = HomeActivity.class.getSimpleName();
    private int normalColor = ContextCompat.getColor(context, R.color.gray), selectedColor = ContextCompat.getColor(context, R.color.colorPrimary);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        installToolbar();


        ViewPager viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        try {
            int[] tabIcons = {
                    R.drawable.ic_home,
                    R.drawable.ic_notification,
                    R.drawable.ic_more
            };

            tabLayout.setTabTextColors(normalColor, selectedColor);
            TabLayout.Tab tab = tabLayout.getTabAt(0);
            if (tab != null) {
                tab.setIcon(tabIcons[0]);
                if (tab.getIcon() != null)
                    tab.getIcon().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);
            }

            tab = tabLayout.getTabAt(1);
            if (tab != null) {
                tab.setIcon(tabIcons[1]);
                if (tab.getIcon() != null)
                    tab.getIcon().setColorFilter(normalColor, PorterDuff.Mode.SRC_IN);
            }


            tab = tabLayout.getTabAt(2);
            if (tab != null) {
                tab.setIcon(tabIcons[2]);
                if (tab.getIcon() != null)
                    tab.getIcon().setColorFilter(normalColor, PorterDuff.Mode.SRC_IN);
            }

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    if (tab.getIcon() != null)
                        tab.getIcon().setColorFilter(selectedColor, PorterDuff.Mode.SRC_IN);

                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    if (tab.getIcon() != null)
                        tab.getIcon().setColorFilter(normalColor, PorterDuff.Mode.SRC_IN);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        } catch (Throwable e) {
            Log.e(TAG, "setupTabIcons: ", e);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new PageFragment(), "Home");
        adapter.addFrag(new PageFragment(), "Notification");
        adapter.addFrag(new PageFragment(), "More");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            // return null to display only the icon
            return mFragmentTitleList.get(position);
        }
    }
}