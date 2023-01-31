package com.example.guruexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guruexample.Room.Community
import kotlinx.android.synthetic.main.community_fragment.view.*

class MainCommunityAdapter(
    private val community: List<Community>
) : RecyclerView.Adapter<MainCommunityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.community_fragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = community[position]
        holder.title.text = item.title
        holder.content.text = item.content
    }

    override fun getItemCount(): Int = community.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.community_title
        val content: TextView = view.community_content

    }
}