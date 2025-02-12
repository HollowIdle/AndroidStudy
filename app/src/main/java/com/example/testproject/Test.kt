package com.example.testproject

fun main(){





}

open class LibraryManagerC(): LibraryManager{

    private var listOfBooks : MutableList<Book?> = mutableListOf()

    override fun displayBooks() : String {
        val resultString : String
        if(listOfBooks.size == 0){
            resultString = "list is empty"
            return resultString
        }
        else{
            resultString = listOfBooks.joinToString("\n"){
                    book: Book? ->
                book?.let {"${it.printTitle() ?: "Unknown Title"} -" +
                        " ${it.printAuthor() ?: "Unknown Author"}" +
                        " (${it.printYear() ?: "Unknown Year"})" } ?: "Unknown book"
            }

        }
        return resultString
    }

    override fun createNewBook(title: String?, author: String?, year: Int?){
        val newBook = Book(title = title,author = author,year = year)
        listOfBooks.add(newBook)
    }

}

interface LibraryManager{

    fun displayBooks() : String
    fun createNewBook(title: String?, author: String?, year: Int?)

}

data class EBook(var title: String,var author: String,var year: Int,var fileSize : Int){

    fun printTitle() : String{
        return this.title
    }

    fun printAuthor() : String{
        return this.author
    }

    fun printYear() : Int{
        return this.year
    }

    fun printFileSize() : Int{
        return this.fileSize
    }
}

data class Book(var title : String?, var author: String?, var year : Int?){

    fun printTitle() : String?{
        return this.title
    }

    fun printAuthor() : String?{
        return this.author
    }

    fun printYear() : Int?{
        return this.year
    }

}