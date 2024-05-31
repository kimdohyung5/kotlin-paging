package com.kimdo.pagingsimple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kimdo.pagingsimple.databinding.ItemViewBinding

class MyAdapter : PagingDataAdapter<User,  MyAdapter.ViewHolder> (DIFF_CALLBACK ) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User> () {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

    class ViewHolder(binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        private val id = binding.id
        private val userName = binding.userName

        fun bind( user: User ){
            id.text = user.id.toString()
            userName.text = user.userName
        }
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val user = getItem(position)
        user?.let {
            holder.bind( it )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
}