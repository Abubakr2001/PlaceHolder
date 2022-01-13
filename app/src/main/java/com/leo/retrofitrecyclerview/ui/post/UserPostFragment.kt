package com.leo.retrofitrecyclerview.ui.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.leo.retrofitrecyclerview.MainActivity
import com.leo.retrofitrecyclerview.R
import com.leo.retrofitrecyclerview.databinding.FragmentUserPostBinding

class UserPostFragment : Fragment() {

    private val binding: FragmentUserPostBinding by lazy {
        FragmentUserPostBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: UserPostAdapter
    private val args: UserPostFragmentArgs by navArgs()
    private val viewModel: UserPostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (requireActivity() as MainActivity).supportActionBar?.title = args.title
        adapter = UserPostAdapter()
        binding.rcViewPost.adapter = adapter

        viewModel.getPostById(args.idUser.toInt())
        viewModel.postData.observe(viewLifecycleOwner,{
            adapter.submitList(it)
        })


        return binding.root
    }


}