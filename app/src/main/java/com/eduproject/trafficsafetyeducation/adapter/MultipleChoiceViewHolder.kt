package com.eduproject.trafficsafetyeducation.adapter

import android.graphics.Color
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


        if (adapter.selectedPosition == adapterPosition)
            binding.cvItemNote.setBackgroundColor(Color.parseColor("#DC746C")) // Selected color
        else
            binding.cvItemNote.background = null
    }
}