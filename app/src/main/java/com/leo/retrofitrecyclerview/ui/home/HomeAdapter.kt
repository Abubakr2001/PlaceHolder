package com.leo.retrofitrecyclerview.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leo.retrofitrecyclerview.databinding.ItemUserBinding
import com.leo.retrofitrecyclerview.model.user.UserDataItem

class HomeAdapter() :
    ListAdapter<UserDataItem, HomeAdapter.UserDataViewHolder>(DiffCallBack) {

    class UserDataViewHolder(var binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {
                binding.userItem?.let { userItem ->
                    navigateUserData(userItem, it)
                }
            }
        }

        private fun navigateUserData(userDataItem: UserDataItem, view: View) {
            val direction = HomeFragmentDirections.actionHomeFragmentToUserPostFragment(
                userDataItem.id.toString(), userDataItem.username
            )
            view.findNavController().navigate(direction)
        }

        fun bind(data: UserDataItem) {
            binding.userItem = data
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<UserDataItem>() {
        override fun areItemsTheSame(oldItem: UserDataItem, newItem: UserDataItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserDataItem, newItem: UserDataItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        return UserDataViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)
    }


}