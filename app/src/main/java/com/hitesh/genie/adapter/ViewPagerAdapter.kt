package com.hitesh.genie.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var mFragmentList: List<Fragment> = ArrayList()

    override fun getCount(): Int {
        return mFragmentList.size;
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    fun addFragment(fragment: Fragment) {

    }


}