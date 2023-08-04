package com.tupleinfotech.secondarydisplaydemo

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.secondarydisplaydemo.databinding.SecondaryDisplayBinding


class SecondaryDisplay(context: Context, display: Display,private val itemlist: List<Secondaryscreenitem>) : Presentation(context, display) {


    private var _binding: SecondaryDisplayBinding? = null
    private val binding get() = _binding!!

    private lateinit var secondaryscreenadapter: Secondaryscreenadapter
    private var secondaryscreenList = itemlist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = SecondaryDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutvisibility()
    }

    //checks the itemlist data on the empty basis.......
   private fun layoutvisibility(){

        if (itemlist.isNotEmpty()) {
            binding.secondaryscreen.visibility = View.VISIBLE
            binding.errorscreen.visibility = View.GONE
            loadScanItemList()
        }else{
            binding.errorscreen.visibility = View.VISIBLE
            binding.secondaryscreen.visibility = View.GONE
        }
    }

    //binds the adapter data with layout
    private fun loadScanItemList() {

        secondaryscreenList = itemlist
        // create  layoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

        val recyclerViewScanItemList = binding.layoutLeft.layoutScanitemList.recyclerViewScanItem
        // pass it to rvLists layoutManager
        recyclerViewScanItemList.layoutManager = layoutManager

        // initialize the adapter,
        // and pass the required argument
        secondaryscreenadapter = Secondaryscreenadapter(secondaryscreenList)

        // attach adapter to the recycler view
        recyclerViewScanItemList.adapter = secondaryscreenadapter

        val horizontalDecoration = DividerItemDecoration(recyclerViewScanItemList.context,DividerItemDecoration.VERTICAL)
        val horizontalDivider = ContextCompat.getDrawable(recyclerViewScanItemList.context, R.drawable.divider_horizontal_dark)
        horizontalDecoration.setDrawable(horizontalDivider!!)

        recyclerViewScanItemList.addItemDecoration(horizontalDecoration)
    }

}