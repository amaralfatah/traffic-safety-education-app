package com.eduproject.trafficsafetyeducation.adapter

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.MainActivity
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding
import com.eduproject.trafficsafetyeducation.pretest.PreTestActivity

class MultipleChoiceViewHolder(
    private val binding: MultipleChoiceItemBinding,
    private val context: Context,
    private val onItemClick: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: String, adapter: MultipleChoiceAdapter, index12: Int) {

        val index = adapterPosition
        val prefix = ('A' + index)
        binding.tvItemName.text = "$prefix. $data"

        itemView.setOnClickListener {
            onItemClick(prefix.toString())
            adapter.updateSelectedPosition(adapterPosition)
        }

        if (adapter.selectedPosition == adapterPosition) {
            binding.cvItemNote.setBackgroundColor(Color.parseColor("#9A93C0FF"))
            if (index12 == 24) {
                (context as PreTestActivity).customDialog()
            }
        } else {
            binding.cvItemNote.background = null
        }

    }
}