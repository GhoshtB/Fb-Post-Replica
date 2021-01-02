package com.example.myapplicationexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationexample.R
import com.example.myapplicationexample.data.model.Posts

class CommentAdapter(val comments: List<Posts.Comments>):RecyclerView.Adapter<CommentAdapter.CommentHolder>() {

    inner class CommentHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvComment= itemView.findViewById<TextView>(R.id.tvComment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        return CommentHolder(LayoutInflater.from(parent.context).inflate(R.layout.comments_row,parent,false))

    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
holder.apply {
    comments[position].let {
        tvComment.text=it.comment
    }
}

    }

    override fun getItemCount(): Int {
      return comments.size
    }
}