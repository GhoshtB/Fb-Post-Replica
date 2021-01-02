package com.example.myapplicationexample.ui.fragment

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationexample.MainActivity
import com.example.myapplicationexample.R
import com.example.myapplicationexample.ui.CommentAdapter
import com.example.myapplicationexample.ui.PostsAdapter


class CommentDialog:AppCompatDialogFragment() {

    private lateinit var rvComments: RecyclerView

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//         super.onCreateDialog(savedInstanceState)
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity as MainActivity)
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog, null)
        rvComments = view.findViewById(R.id.rvComments) as RecyclerView
        rvComments.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = CommentAdapter((activity as MainActivity).posts[(activity as MainActivity).clickedPos].comments)
        }
        (activity as MainActivity).isShowing=true
        builder.setView(view)
//            .setTitle("Login")
            /*.setNegativeButton("cancel",
                { dialogInterface, i -> })
            .setPositiveButton("ok",  { dialogInterface, i ->

            })*/

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

}