package com.cnon.zodiac

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.single_row.view.*
import java.sql.Array

class zodiacBaseAdapter(context: Context, allZodiac2: ArrayList<com.cnon.zodiac.Zodiac>) : BaseAdapter()
{

  var allZodiac: ArrayList<com.cnon.zodiac.Zodiac>
   var context: Context

    init {

       allZodiac=allZodiac2

      //  allZodiac = ArrayList<Zodiac>()
        this.context = context


        /*
         var zodiacName = context.resources.getStringArray(R.array.zodiac)
        var zodiacIDate = context.resources.getStringArray(R.array.zodiacDates)
        var zodiacSymbol = arrayOf(R.drawable.aries,R.drawable.taurus,R.drawable.gemini, R.drawable.cancer, R.drawable.leo
        ,R.drawable.virgo,R.drawable.libra,R.drawable.scorpio,R.drawable.sagittarius,R.drawable.capricorn,R.drawable.aquarius,
        R.drawable.pisces)

        for (i in 0..10)
        {
            var arrayWillBeListedZodiac = Zodiac(zodiacName[i],zodiacIDate[i],zodiacSymbol[i])
            allZodiac.add(arrayWillBeListedZodiac)
        }
         */




    }


    override fun getCount(): Int {

        return allZodiac.size

    }

    override fun getItem(p0: Int): Any {
        return allZodiac.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return  0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var singleRowView = p1
        var viewHolder: viewHolder

        if(singleRowView==null)
        {
            var inflater = LayoutInflater.from(context)
            singleRowView = inflater.inflate(R.layout.single_row,p2,false)
            viewHolder = viewHolder(singleRowView)
            singleRowView.tag = viewHolder
        }
        else
        {
            viewHolder = singleRowView.getTag() as viewHolder
        }

        viewHolder.zodiacImage.setImageResource(allZodiac.get(p0).burcSembol)
        viewHolder.zodiacName.setText(allZodiac.get(p0).zodiacName)
        viewHolder.zodiacIDate.setText(allZodiac.get(p0).zodiacIDate)

        Log.e("Inflater",allZodiac.get(p0).zodiacName)


        return singleRowView!!
    }

    data class Zodiac (var zodiacName:String, var zodiacIDatei:String, var burcSembol:Int) {}

    class viewHolder(single_row_view : View)
    {

        var zodiacImage : ImageView
        var zodiacName : TextView
        var zodiacIDate : TextView

        init {
            this.zodiacImage = single_row_view.imgZodiacSymbol
            this.zodiacName = single_row_view.tvZodiacName
            this.zodiacIDate = single_row_view.tvZodiacDate
        }


    }


}