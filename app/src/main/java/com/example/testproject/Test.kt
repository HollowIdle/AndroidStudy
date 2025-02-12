package com.example.testproject

fun main(){}

open class LibraryManagerC: LibraryManager{

    private val listOfBooks : MutableList<Book?> = mutableListOf()

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

data class EBook(var title: String?,var author: String?,var year: Int?,var fileSize : Int? = 0){
    fun printTitle() : String? = title
    fun printAuthor() : String? = author
    fun printYear() : Int? = year
    fun printFileSize() : Int? = fileSize
}

data class Book(
    val title : String?,
    val author: String?,
    val year : Int?
){
    fun printTitle() : String? = title
    fun printAuthor() : String? = author
    fun printYear() : Int? = year
}

internal fun Book.toEBook(): EBook =
    EBook(
        title = title ?: "Unknown",
        author = author ?: "Unknown",
        year = year ?: 0
    )