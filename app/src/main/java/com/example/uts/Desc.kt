package com.example.uts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView

class Desc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_desc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image: ItemData? = intent.getParcelableExtra("Image")

        if (image != null) {
            val imageView: ImageView = findViewById(R.id._imageDetail)
            val namaView: TextView = findViewById(R.id._imageTitle)
            val descView: TextView = findViewById(R.id._imageDesc)

            imageView.setImageResource(image.imageFlora)
            namaView.text = image.name
            descView.text = image.description
        }
    }
}