package com.example.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val circleView: CircleView = findViewById(R.id.circleView)

        val item = intent.getStringExtra("ITEM")

        circleView.setNumber(item ?: "1")
    }
}

