package com.example.myproject1

data class Country (
    val name : String,
    val capital : String,
    val area : Long,
    val population : Long,
    val languages : List<Languages>,
    val flag : String
)

data class Languages (
    val name : String
)