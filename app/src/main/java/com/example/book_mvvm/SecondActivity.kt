package com.example.book_mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var tvName:TextView
    private lateinit var tvMobile:TextView
    private lateinit var tvBook : TextView
    private lateinit var updateData: Button

    companion object{
        const val NAME = "NAME"
        const val MOBILE = "MOBILE"
        const val BOOK = "BOOK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvName = findViewById(R.id.tvName)
        tvMobile = findViewById(R.id.tvMobile)
        tvBook = findViewById(R.id.tvBook)
        updateData = findViewById(R.id.update_data)

        val name = intent.getStringExtra(NAME)
        val mobile = intent.getStringExtra(MOBILE)
        val book = intent.getStringExtra(BOOK)

        tvName.text = "Name:- $name"
        tvMobile.text = "Mobile Number:- $mobile"
        tvBook.text = "Your Book:- $book"

        updateData.setOnClickListener {
            val intent = Intent(this@SecondActivity,MainActivity::class.java)
            startActivity(intent)
        }


    }
}