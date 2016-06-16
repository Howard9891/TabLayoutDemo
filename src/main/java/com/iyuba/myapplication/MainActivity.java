package com.iyuba.myapplication;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.iyuba.myapplication.view.AppActivity;
import com.iyuba.myapplication.view.BaseFragment;
import com.iyuba.myapplication.view.SubFragment;
import com.iyuba.myapplication.view.SubFragment1;
import com.iyuba.myapplication.view.SubFragment2;
import com.iyuba.myapplication.view.SubFragment3;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppActivity {
    private ViewPager viewPager;
    private TabLayout tab;
    private String[] tabs = new String[]{"news","hots","more"};
    private List<BaseFragment> fragments = new ArrayList<BaseFragment>();
    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
    @Override
    protected int getFragmentContentId() {
        return 0;
    }
    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }
    @Override
    protected void findViewById() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText(tabs[0]));
        tab.addTab(tab.newTab().setText(tabs[1]));
        tab.addTab(tab.newTab().setText(tabs[2]));
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewPager);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    protected void initData() {
        fragments.add(new SubFragment1());
        fragments.add(new SubFragment2());
        fragments.add(new SubFragment3());
    }
    class MyViewPagerAdapter extends FragmentPagerAdapter{
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];

        }
    }
}
