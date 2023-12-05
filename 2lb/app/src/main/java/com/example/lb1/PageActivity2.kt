package com.example.lb1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PageActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        val title : TextView = findViewById(R.id.item_name_new)
        val desc : TextView = findViewById(R.id.item_desc_new)
        val image : ImageView = findViewById(R.id.item_image_new)
        val butt_back : Button = findViewById(R.id.item_button_back)

        butt_back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        title.text = intent.getStringExtra("item_name")
        desc.text = intent.getStringExtra("item_desc")
        val imageId = resources.getIdentifier(intent.getStringExtra("item_image"), "drawable", packageName)
        image.setImageResource(imageId)

    }
}