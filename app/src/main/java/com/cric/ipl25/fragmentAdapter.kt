package com.cric.ipl25

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class fragmentAdapter(fm:FragmentManager,lc:androidx.lifecycle.Lifecycle):FragmentStateAdapter(fm,lc) {

    var fragmentArray=ArrayList<Fragment>()

    fun addFragment(fragment: Fragment){
        fragmentArray.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragmentArray.size
    }

    override fun createFragment(p0: Int): Fragment {
        return fragmentArray.get(p0)
    }
}