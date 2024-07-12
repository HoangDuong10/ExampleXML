package com.example.layout.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.layout.adapter.TimeLineAdapter
import com.example.layout.databinding.FragmentTimeLineBinding
import com.example.layout.model.TimeLineUser
import java.time.LocalTime
import kotlin.random.Random

class TimeLineFragment : Fragment() {
    private lateinit var timeLineFragmentBinding: FragmentTimeLineBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        timeLineFragmentBinding = FragmentTimeLineBinding.inflate(layoutInflater)
        timeLineFragmentBinding.rcvTimeline.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        val adapter = TimeLineAdapter(getList(),requireContext())
        timeLineFragmentBinding.rcvTimeline.adapter = adapter
        return timeLineFragmentBinding.root

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getList(): List<TimeLineUser> {
        val list: MutableList<TimeLineUser> = mutableListOf()
        list.add(TimeLineUser("Dương đã đặt một sản peeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeehẩm",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sảuuuuuuuuuuuuuun phẩm1",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sản phẩm2",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sản phẩm3",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sản phẩm4",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sản phẩm5",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sản phẩm6",getRandomTime()))
        list.add(TimeLineUser("Dương đã đặt một sản phẩm7",getRandomTime()))
        return list
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getRandomTime(): LocalTime {
        val randomHour = Random.nextInt(0, 24)
        val randomMinute = Random.nextInt(0, 60)
        return LocalTime.of(randomHour, randomMinute)
    }
}