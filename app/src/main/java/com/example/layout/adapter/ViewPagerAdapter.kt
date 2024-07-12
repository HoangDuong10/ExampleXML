package com.example.layout.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.layout.fragment.JourneyFragment
import com.example.layout.fragment.OrderFragment
import com.example.layout.fragment.TimeLineFragment

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return JourneyFragment()
            1 -> return OrderFragment()
            2 -> TimeLineFragment()
        }
        return TimeLineFragment()
    }
}