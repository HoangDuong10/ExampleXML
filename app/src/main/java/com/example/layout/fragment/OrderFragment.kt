package com.example.layout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.layout.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {
    private lateinit var orderFragmentBinding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        orderFragmentBinding = FragmentOrderBinding.inflate(layoutInflater)
        return orderFragmentBinding.root
    }
}