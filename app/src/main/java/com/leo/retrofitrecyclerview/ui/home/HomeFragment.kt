package com.leo.retrofitrecyclerview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leo.retrofitrecyclerview.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        adapter = HomeAdapter()
        binding.rcView.adapter = adapter

        viewModel.userData.observe(viewLifecycleOwner,{
            adapter.submitList(it)
        })

        return binding.root
    }


}