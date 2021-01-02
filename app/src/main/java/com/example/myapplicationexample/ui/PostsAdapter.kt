package com.example.myapplicationexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.data.model.Posts

class PostsAdapter(val posts: List<Posts>,val activity: MainActivity):RecyclerView.Adapter<PostsAdapter.PostsHolder>() {


    inner class PostsHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvpostName= itemView.findViewById<TextView>(R.id.tvpostName)
        val tvpost_det= itemView.findViewById<TextView>(R.id.tvpost_det)
        val tvcmntsshrs= itemView.findViewById<TextView>(R.id.tvcmntsshrs)
        val tvlike= itemView.findViewById<TextView>(R.id.tvlike)
        val tvcmnts= itemView.findViewById<TextView>(R.id.tvcmnts)
        val tvShares= itemView.findViewById<TextView>(R.id.tvShares)
        val rlComment= itemView.findViewById<RelativeLayout>(R.id.rlComment)
        val llOthers= itemView.findViewById<LinearLayout>(R.id.llOthers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsHolder {
        return PostsHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_view_rows,parent,false))
    }

    override fun onBindViewHolder(holder: PostsHolder, position: Int) {
        holder.apply {
            posts[position].let {
//                tvpostName.text=it.postName
                tvShares.text= "${ it.shares } shares"
                tvlike.text= "${ it.likes } likes"
                tvcmnts.text= "${ it.comments.size } Comments"
            }
            llOthers.setOnClickListener {
              activity.openDialog(position)
            }
            rlComment.setOnClickListener {
              activity.openDialog(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}