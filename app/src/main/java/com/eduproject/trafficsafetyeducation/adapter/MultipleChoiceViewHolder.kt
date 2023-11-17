package com.eduproject.trafficsafetyeducation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding

class MultipleChoiceViewHolder(
    private val binding: MultipleChoiceItemBinding
): RecyclerView.ViewHolder(binding.root)  {

    fun bind(data:String){

        val index = adapterPosition
        val prefix = ('A' + index)
        binding.tvItemName.text = "$prefix. $data"

    }
}