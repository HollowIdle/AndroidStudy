package com.example.testproject

interface LibraryManager{
    fun displayBooks() : String
    fun createNewBook(title: String?, author: String?, year: Int?)
}