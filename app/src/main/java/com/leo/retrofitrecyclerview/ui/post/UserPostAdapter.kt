package com.leo.retrofitrecyclerview.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leo.retrofitrecyclerview.databinding.ItemPostBinding
import com.leo.retrofitrecyclerview.model.post.PostDataItem

class UserPostAdapter():
    ListAdapter<PostDataItem, UserPostAdapter.UserPostHolder>(DiffCallBack) {

    class UserPostHolder(var binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: PostDataItem){
            binding.postItem = data
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<PostDataItem>() {
        override fun areItemsTheSame(oldItem: PostDataItem, newItem: PostDataItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PostDataItem, newItem: PostDataItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostHolder {
        return UserPostHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: UserPostHolder, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)
    }

}