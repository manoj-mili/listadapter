package com.carnot.recyclerviewlistadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postList = getListOfPost(5)
        adapter = PostAdapter()
        rvTask.adapter = adapter

        updatePostAdapter(postList)

        fbRefresh.setOnClickListener {
            val updatedPostList = getListOfPost(10)
            updatePostAdapter(updatedPostList)
        }
    }

    fun updatePostAdapter(postList: List<Post>) {
        adapter.submitList(postList)
    }

}
