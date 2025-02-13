package com.example.testproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val libManager = LibraryManagerC()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val addBookButton = binding.AddBookButton
        addBookButton.setOnClickListener{ createBookInfoFromFields() }

        displayList()
    }

    private fun createBookInfoFromFields() {
        val title = binding.TitleTextField.text.toString()
        val author = binding.AuthorTextField.text.toString()
        val yearText = binding.YearTextField.text.toString()

        if(title == "" || author == "" || yearText == ""){
            return
        }

        val year = yearText.toInt()

        libManager.createNewBook(title = null, author = null, year = null)
        libManager.createNewBook(title = title, author = author, year = year)

        cleanTextFields()
        displayList()
    }

    private fun cleanTextFields(){
        val titleTextField = findViewById<EditText>(R.id.TitleTextField)
        titleTextField.text = null
        val authorTextField = findViewById<EditText>(R.id.AuthorTextField)
        authorTextField.text = null
        val yearTextField = findViewById<EditText>(R.id.YearTextField)
        yearTextField.text = null
    }

    private fun displayList(){
        val textViewForBookList = findViewById<TextView>(R.id.BooksListTextView)
        textViewForBookList.text = libManager.displayBooks()
    }
}