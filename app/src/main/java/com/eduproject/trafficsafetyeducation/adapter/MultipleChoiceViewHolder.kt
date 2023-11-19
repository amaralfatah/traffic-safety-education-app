package com.eduproject.trafficsafetyeducation.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.MainActivity
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding

class MultipleChoiceViewHolder(
    private val binding: MultipleChoiceItemBinding,
    private val context: Context,
    private val onItemClick: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, adapter: MultipleChoiceAdapter, index12:Int) {

        val index = adapterPosition
        val prefix = ('A' + index)
        binding.tvItemName.text = "$prefix. $data"

        itemView.setOnClickListener {
            onItemClick(prefix.toString())
            adapter.updateSelectedPosition(adapterPosition)
        }

        if (adapter.selectedPosition == adapterPosition) {
            binding.cvItemNote.setBackgroundColor(Color.parseColor("#9A93C0FF"))
            if(index12==5){
                (context as MainActivity).customDialog()
            }
            Log.d("MultipleChoiceViewHolder", "Setting selected color for position: $adapterPosition")
        } else {
            binding.cvItemNote.background = null
            Log.d("MultipleChoiceViewHolder", "Setting default color for position: $adapterPosition")
        }

    }
}