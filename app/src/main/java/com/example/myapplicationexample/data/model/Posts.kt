package com.example.myapplicationexample.data.model

data class Posts(val postName:String,val comments: List<Comments>,val likes:String,val shares:String) {
    data class Comments(val comment:String)
}