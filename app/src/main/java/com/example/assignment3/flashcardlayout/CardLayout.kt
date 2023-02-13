package com.example.assignment3.flashcardlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3.R

class CardLayout {


    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.second_layout)
        }
    }
}