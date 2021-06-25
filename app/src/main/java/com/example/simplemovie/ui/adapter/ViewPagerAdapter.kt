package com.example.simplemovie.ui.adapter

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(@NonNull fm: FragmentManager?, var fragmentList: MutableList<Fragment?>?) :
    FragmentStatePagerAdapter(fm!!) {
    @NonNull
    override fun getItem(position: Int): Fragment {
        return fragmentList?.get(position)!!
    }

    override fun getCount(): Int {
        return fragmentList?.size!!
    }
}