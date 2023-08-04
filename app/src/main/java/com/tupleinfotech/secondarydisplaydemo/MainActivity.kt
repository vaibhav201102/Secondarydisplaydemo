package com.tupleinfotech.secondarydisplaydemo

import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tupleinfotech.secondarydisplaydemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding?= null
    private val binding get() = _binding!!

    private lateinit var secondaryscreenitemList: List<Secondaryscreenitem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        secondaryscreenbinding()
    }

    // this function binds the main activity with the secondary screen with data that is used in adapter
    private fun secondaryscreenbinding(){

        /*
        scanItemList = listOf(
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
            ScanItem("1" , "123456789","ITEM 112","1","$40.00"),
        )
*/

        secondaryscreenitemList = emptyList()

        val displayManager = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        if (displays.isNotEmpty()) {
            // Assuming the first display is the secondary display
            val secondaryDisplay = displays[0]
            val presentation = SecondaryDisplay(this, secondaryDisplay,secondaryscreenitemList)
            presentation.show()
        }

    }

}