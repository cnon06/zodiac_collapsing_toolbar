package com.cnon.zodiac

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout


class MainActivity : AppCompatActivity() {

    lateinit var allZodiac: ArrayList<Zodiac>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
      setContentView(R.layout.activity_main)


        /*
           var zodiac = resources.getStringArray(R.array.zodiac)
        var zodiacDates = resources.getStringArray(R.array.zodiacDates)
        var zodiacImages = arrayOf(R.drawable.aries, R.drawable.taurus, R.drawable.gemini, R.drawable.cancer
                ,R.drawable.leo, R.drawable.virgo, R.drawable.libra, R.drawable.scorpio, R.drawable.sagittarius,
            R.drawable.capricorn,R.drawable.aquarius,R.drawable.pisces);
         */
       allZodiac = ArrayList(12)
        prepareDataSource()

        var listView = findViewById<ListView>(R.id.listZodiac)


        //listView.adapter = zodiacArrayAdapter(this,R.layout.single_row,R.id.tvZodiacName,zodiac,zodiacDates,zodiacImages)
       listView.adapter = zodiacBaseAdapter(this, allZodiac)


        listView.setOnItemClickListener { adapterView, view, i, l ->




        //  val gecici = view as TextView
          //  Toast.makeText(this,gecici.text,Toast.LENGTH_SHORT).show()
           // println(gecici.text)
            //println("fdfg")

           var intent = Intent(this, MainActivity2 :: class.java)
            intent.putExtra("position",i)
            intent.putExtra("zodiacInfo",allZodiac[i])
            startActivity(intent)



        }

    }

    private fun prepareDataSource()
    {


        var zodiacName = resources.getStringArray(R.array.zodiac)
        var zodiacIDate = resources.getStringArray(R.array.zodiacDates)
        var zodiacSymbol = arrayOf(R.drawable.aries,R.drawable.taurus,R.drawable.gemini, R.drawable.cancer, R.drawable.leo
            ,R.drawable.virgo,R.drawable.libra,R.drawable.scorpio,R.drawable.sagittarius,R.drawable.capricorn,R.drawable.aquarius,
            R.drawable.pisces)


        for (i in 0..10)
        {
          allZodiac.add(Zodiac(zodiacName[i], zodiacIDate[i], zodiacSymbol[i]))
        }

    }

    }







