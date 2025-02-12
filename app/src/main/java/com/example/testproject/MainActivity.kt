package com.example.testproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

val libManager = LibraryManagerC()

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fun displayList(){
            val textViewForBookList = findViewById<TextView>(R.id.BooksListTextView)
            textViewForBookList.setText(libManager.displayBooks())
        }

        fun cleanTextFields(){
            val titleTextField = findViewById<EditText>(R.id.TitleTextField)
            titleTextField.text = null
            val authorTextField = findViewById<EditText>(R.id.AuthorTextField)
            authorTextField.text = null
            val yearTextField = findViewById<EditText>(R.id.YearTextField)
            yearTextField.text = null
        }

        fun createBookInfoFromFields() {
            val titleTextField = findViewById<EditText>(R.id.TitleTextField)
            val title = titleTextField.text.toString()
            val authorTextField = findViewById<EditText>(R.id.AuthorTextField)
            val author = authorTextField.text.toString()
            val yearTextField = findViewById<EditText>(R.id.YearTextField)
            val yearText = yearTextField.text.toString()

            if(title == "" || author == "" || yearText == ""){
                return
            }

            val year = yearText.toInt()

            libManager.createNewBook(title = null, author = null, year = null)

            libManager.createNewBook(title = title, author = author, year = year)

            cleanTextFields()

            displayList()

        }

        val addBookButton = findViewById<Button>(R.id.AddBookButton)

        addBookButton.setOnClickListener{
            createBookInfoFromFields()
        }

        displayList()

    }
}