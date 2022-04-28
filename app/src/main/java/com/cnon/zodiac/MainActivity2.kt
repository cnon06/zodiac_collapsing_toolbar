package com.cnon.zodiac

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.palette.graphics.Palette
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    lateinit  var allZodiac : Zodiac

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




       // val header = findViewById<View>(R.id.header) as ImageView


       // var position = intent.extras?.get("position") as Int
        allZodiac = intent.extras?.get("zodiacInfo") as Zodiac
        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = allZodiac.zodiacName

        Toast.makeText(this, "The Position of Clicked Object: "+allZodiac.zodiacName, Toast.LENGTH_SHORT).show()

        var img = findViewById<ImageView>(R.id.header)
        img.setImageResource(allZodiac.burcSembol)

        var bitmap = BitmapFactory.decodeResource(resources,allZodiac.burcSembol)
        Palette.from(bitmap).generate(object: Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
               var color =  palette?.getVibrantColor(androidx.appcompat.R.attr.color)

                    collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor=color

            }


        })





      //  Toast.makeText(this, "The Position of Clicked Object: ",position.toString(), Toast.LENGTH_SHORT).show()

    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return super.onSupportNavigateUp()


    }

}