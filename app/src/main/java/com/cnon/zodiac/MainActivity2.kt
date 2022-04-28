package com.cnon.zodiac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit  var allZodiac : Zodiac

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var position = intent.extras?.get("position") as Int
        allZodiac = intent.extras?.get("zodiacInfo") as Zodiac

        Toast.makeText(this, "The Position of Clicked Object: "+allZodiac.zodiacName, Toast.LENGTH_SHORT).show()

        var img = findViewById<ImageView>(R.id.header)
        img.setImageResource(allZodiac.burcSembol)

      //  Toast.makeText(this, "The Position of Clicked Object: ",position.toString(), Toast.LENGTH_SHORT).show()

    }
}