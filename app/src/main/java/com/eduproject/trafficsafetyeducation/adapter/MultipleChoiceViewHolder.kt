package com.eduproject.trafficsafetyeducation.adapter

import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding

class MultipleChoiceViewHolder(
    private val binding: MultipleChoiceItemBinding,
    private val onItemClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, adapter: MultipleChoiceAdapter) {

        val index = adapterPosition
        val prefix = ('A' + index)
        binding.tvItemName.text = "$prefix. $data"

        itemView.setOnClickListener {
            onItemClick(prefix.toString())
            adapter.updateSelectedPosition(adapterPosition)
        }


        if (adapter.selectedPosition == adapterPosition) {
            binding.cvItemNote.setBackgroundColor(Color.parseColor("#9A93C0FF"))
            Log.d("MultipleChoiceViewHolder", "Setting selected color for position: $adapterPosition")
        } else {
            binding.cvItemNote.background = null
            Log.d("MultipleChoiceViewHolder", "Setting default color for position: $adapterPosition")
        }

    }
}