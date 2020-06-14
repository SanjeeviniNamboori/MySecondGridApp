package com.example.mysecondgridapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mysecondgridapp.MainActivity
import kotlinx.android.synthetic.main.item_details.*

class ItemDetails : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_details)

        var bundle :Bundle ?=intent.extras

        itemDetailImage.setImageResource(bundle!!.getInt("image"))
        itemName.text = bundle.getString("name")
        itemDescription.text =bundle.getString("description")

    }
}