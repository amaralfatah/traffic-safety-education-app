package com.eduproject.trafficsafetyeducation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding

class MultipleChoiceAdapter(
    private var list: List<String>,
    private var currentAnswer: String,
    private var index: Int,
    private var usage: String,
    private val context: Context,
    private val onItemClick: (String) -> Unit,
) : RecyclerView.Adapter<MultipleChoiceViewHolder>() {

    // Variable to keep track of the selected position
    var selectedPosition = -1
    init {
        updateSelectedPositionBasedOnCurrentAnswer()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleChoiceViewHolder {
        return MultipleChoiceViewHolder(
            MultipleChoiceItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            context,
            onItemClick
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MultipleChoiceViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data, this, index, usage)

    }

    fun updateData(newList: List<String>, newindex: Int, newCurrentAnswer: String) {
        list = newList
        index = newindex
        currentAnswer = newCurrentAnswer
        updateSelectedPositionBasedOnCurrentAnswer()
        notifyDataSetChanged()
    }

    // Method to update the selected position
    fun updateSelectedPosition(newPosition: Int) {
        val oldPosition = selectedPosition

        selectedPosition = newPosition
        notifyItemChanged(oldPosition)
        notifyItemChanged(newPosition)
    }
    private fun updateSelectedPositionBasedOnCurrentAnswer() {
        selectedPosition = when (currentAnswer) {
            "A" -> 0
            "B" -> 1
            "C" -> 2
            else -> -1
        }
    }
}