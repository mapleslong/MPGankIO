package com.mapleslong.gankio.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class GankViewPagerAdapter extends FragmentStatePagerAdapter {
    /*
        为什么使用FragmentStateAdapter而不用FragmentPagerAdapter是因为viewpager页数比较多
        FragmentStateAdatper的机制是空置的时候将其销毁释放内存,而FragmentPagerAdapter是将其dettach
        因此选用SteteAdapter进行优化
     */
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public GankViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
