package com.carnot.recyclerviewlistadapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PostAdapter :
    ListAdapter<Post, PostAdapter.ViewHolder>(TaskDiffCallBack()) {


    //This check runs on background thread
    class TaskDiffCallBack : DiffUtil.ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            Log.d("ListAdapterRecyclerView",Thread.currentThread().name)
            return oldItem.id == newItem.id;
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
            Log.d("ListAdapterRecyclerView",Thread.currentThread().name)
            return oldItem == newItem
        }
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = getItem(position)
        holder.tvDesc.text = task.body
        holder.tvTitle.text = task.title
        Log.d("ListAdapterRecyclerView",Thread.currentThread().name)
    }
}