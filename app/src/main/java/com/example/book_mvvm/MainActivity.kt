package com.example.book_mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var edit_name:EditText
    private lateinit var edit_mobileNumber:EditText
    private lateinit var book_spinner:Spinner
    private lateinit var submit : Button
    private lateinit var text:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_name = findViewById(R.id.edit_name)
        edit_mobileNumber = findViewById(R.id.edit_mobileNumber)
        book_spinner = findViewById(R.id.spinner)
        submit = findViewById(R.id.btn_submit)

        val books = resources.getStringArray(R.array.books)

        if (book_spinner!= null){
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,books)
            book_spinner.adapter = adapter
            book_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@MainActivity,getString(R.string.app_name)+" "+""+books[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@MainActivity, "Item not Selected", Toast.LENGTH_SHORT).show()
                }

            }
        }

        submit.setOnClickListener {
            val name = edit_name.text.toString()
            val mobileNumber = edit_mobileNumber.text.toString()
            val spinner = book_spinner.selectedItem.toString()

            if (name.isEmpty()){
                edit_name.error = "Please Enter name"
            }
            if (mobileNumber.isEmpty() || mobileNumber<= 10.toString()){
                edit_mobileNumber.error = "Please Enter Valid Number"
            }

            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra(SecondActivity.NAME,name)
            intent.putExtra(SecondActivity.MOBILE,mobileNumber)
            intent.putExtra(SecondActivity.BOOK,spinner)
            startActivity(intent)

        }





    }
}