package com.example.layout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.layout.databinding.FragmentJourneyBinding

class JourneyFragment : Fragment() {
    private lateinit var journeyFragmentBinding: FragmentJourneyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        journeyFragmentBinding = FragmentJourneyBinding.inflate(layoutInflater)
        return journeyFragmentBinding.root
    }
}