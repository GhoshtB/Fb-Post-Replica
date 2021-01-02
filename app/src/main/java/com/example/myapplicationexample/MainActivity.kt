package com.example.myapplicationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationexample.data.model.Posts
import com.example.myapplicationexample.ui.PostsAdapter
import com.example.myapplicationexample.ui.fragment.CommentDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    internal lateinit var commentDialog: CommentDialog
    lateinit var rvPosts: RecyclerView
   internal var posts: ArrayList<Posts> = arrayListOf()
    internal var clickedPos = 0
    internal var isShowing =false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPosts = findViewById(R.id.rvPosts) as RecyclerView

        GlobalScope.launch(context = Dispatchers.Main) {
            rvPosts.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
                adapter = PostsAdapter(getPosts(), this@MainActivity)
            }

        }

    }

    fun openDialog(pos: Int) {
        clickedPos = pos
         commentDialog = CommentDialog()
        commentDialog.show(supportFragmentManager, "dialog")

    }

    override fun onBackPressed() {

        if (isShowing){
            commentDialog.dismiss()
            isShowing=false
        }else{
          super.onBackPressed()
        }
    }

    private suspend fun getPosts(): List<Posts> {
        return withContext(context = Dispatchers.Default) {
            posts = arrayListOf(
                Posts(
                    postName = "",
                    comments = arrayListOf(
                        Posts.Comments(comment = "void misspellings, gimmicky characters, gibberish, and automated or distracting content.")
                       , Posts.Comments(comment = "You can publish your offers, events, products, and services directly to Google Search and Maps through posts on")
                       , Posts.Comments(comment = "You can publish your offers, events, products, and services directly to Google Search and Maps through posts on")
                       , Posts.Comments(comment = "You can publish your offers, events, products, and services directly to Google Search and Maps through posts on")
                       , Posts.Comments(comment = "You can publish your offers, events, products, and services directly to Google Search and Maps through posts on")
                    ), likes = "21", shares = "31"
                ),
                Posts(
                    postName = "",
                    comments = arrayListOf(
                        Posts.Comments("Before you create your first post")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                    ), likes = "11", shares = "41"
                ),
                Posts(
                    postName = "",
                    comments = arrayListOf(
                        Posts.Comments("Before you create your first post"),
                        Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = " Links that lead to malware, viruses, phishing, or pornographic material aren’t allowed.")
                        ,Posts.Comments(comment = " Links that lead to malware, viruses, phishing, or pornographic material aren’t allowed.")
                        ,Posts.Comments(comment = " Links that lead to malware, viruses, phishing, or pornographic material aren’t allowed.")
                        ,Posts.Comments(comment = " Links that lead to malware, viruses, phishing, or pornographic material aren’t allowed.")
                    ), likes = "11", shares = "41"
                ),
                Posts(
                    postName = "",
                    comments = arrayListOf(
                        Posts.Comments("Before you create your first post")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                        ,Posts.Comments(comment = "Refrain from obscene, profane, or offensive language, images, or videos.")
                    ), likes = "11", shares = "41"
                ),
            )
            posts
        }

    }


}