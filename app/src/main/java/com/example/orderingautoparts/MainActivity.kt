package com.example.orderingautoparts

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity(), AdapterView.OnItemSelectedListener {
    var parts = arrayListOf<Part>(
        Part(R.drawable.parts_1, "Part 1", "Description part 1"),
        Part(R.drawable.parts_2, "Part 2", "Description part 2"),
        Part(R.drawable.parts_3, "Part 3", "Description part 3"),
        Part(R.drawable.parts_4, "Part 4", "Description part 4"),
        Part(R.drawable.parts_5, "Part 5", "Description part 5"),
        Part(R.drawable.parts_6, "Part 6", "Description part 6"),
        Part(R.drawable.parts_7, "Part 7", "Description part 7"),
        Part(R.drawable.parts_8, "Part 8", "Description part 8"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAutoParts.adapter = MyAdapter(this, parts)
        listAutoParts.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, position, id ->
            val part = parent.getItemAtPosition(position) as Part
            imageOrder.setImageResource(part.imageId)
            tv10.text = part.name
            tv11.text = part.discription
        }

        spinnerCarName.onItemSelectedListener = this
        val adapterCar = ArrayAdapter.createFromResource(
            this,
            R.array.cars,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerCarName.adapter = adapterCar
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val adapterModel = ArrayAdapter.createFromResource(
            this,
            chooseCarModels(position),
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerCarModel.adapter = adapterModel
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun chooseCarModels(pos: Int): Int {
        var res = 0
        when (pos) {
            0 -> res = R.array.nissan_models
            1 -> res = R.array.honda_models
            2 -> res = R.array.acura_models
            3 -> res = R.array.toyota_models
        }
        return res
    }

    fun onClickButtonOrder(view: View) {
        linearLayoutOrder.visibility = View.GONE
        constraintLayoutOrder.visibility = View.VISIBLE

        tv4.text = editTextName.text.toString()
        tv6.text = editTextPhone.text.toString()
        tv8.text = spinnerCarName.selectedItem.toString() + " " + spinnerCarModel.selectedItem.toString()
    }

    fun onClickButtonOK(view: View) {
        linearLayoutOrder.visibility = View.VISIBLE
        constraintLayoutOrder.visibility = View.GONE
    }
}