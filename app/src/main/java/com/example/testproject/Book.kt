package com.example.testproject

data class Book(
    val title : String?,
    val author: String?,
    val year : Int?
){
    fun printTitle() : String? = title
    fun printAuthor() : String? = author
    fun printYear() : Int? = year
}