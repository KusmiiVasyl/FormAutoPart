package com.example.orderingautoparts

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Part>) :
    ArrayAdapter<Part>(context, R.layout.activity_list_auto_parts, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.activity_list_auto_parts,null)

        val image: ImageView = view.findViewById(R.id.imagePart)
        val partName: TextView = view.findViewById(R.id.partName)
        val partDescription: TextView = view.findViewById(R.id.partDescription)

        image.setImageResource(arrayList[position].imageId)
        partName.text = arrayList[position].name
        partDescription.text = arrayList[position].discription

        return view
    }

}