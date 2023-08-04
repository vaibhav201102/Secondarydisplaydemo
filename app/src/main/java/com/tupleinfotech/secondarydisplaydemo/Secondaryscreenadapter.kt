package com.tupleinfotech.secondarydisplaydemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.tupleinfotech.secondarydisplaydemo.databinding.LayoutTableRowSecondaryscreenBinding


class Secondaryscreenadapter(var languageList: List<Secondaryscreenitem>,) : RecyclerView.Adapter<Secondaryscreenadapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutTableRowSecondaryscreenBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutTableRowSecondaryscreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(languageList[position]){

                binding.tvSrno.text = this.srno
                binding.tvItemcode.text = this.itemcode
                binding.tvItemname.text = this.itemname
                binding.tvPrice.text = this.price
                binding.tvQty.text = this.qty

                if(position%2==0){
                    binding.tableRow.setBackgroundColor(ContextCompat.getColor(binding.tableRow.context,
                        R.color.odd_row
                    ))
                }else{
                    binding.tableRow.setBackgroundColor(
                        ContextCompat.getColor(binding.tableRow.context,
                        R.color.white
                    ))
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return languageList.size
    }
}



