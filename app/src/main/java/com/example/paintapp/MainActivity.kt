package com.example.paintapp

import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object{//this is similar to the "public static " in java making the variables available to all the classes in the project
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redButton = findViewById<ImageButton>(R.id.redColor)
        val greenButton = findViewById<ImageButton>(R.id.greenColor)
        val blackButton = findViewById<ImageButton>(R.id.blackColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)

        redButton.setOnClickListener{
            Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
        }

        greenButton.setOnClickListener{
            Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
        }

        blackButton.setOnClickListener{
            Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
        }

        eraser.setOnClickListener{
            Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show()
        }
    }


}