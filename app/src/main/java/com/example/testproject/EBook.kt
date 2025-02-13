package com.example.testproject

data class EBook(var title: String?,var author: String?,var year: Int?,var fileSize : Int? = 0){
    fun printTitle() : String? = title
    fun printAuthor() : String? = author
    fun printYear() : Int? = year
    fun printFileSize() : Int? = fileSize
}