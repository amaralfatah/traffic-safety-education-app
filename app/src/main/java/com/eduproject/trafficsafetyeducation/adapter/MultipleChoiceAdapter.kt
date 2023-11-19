package com.eduproject.trafficsafetyeducation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding

class MultipleChoiceAdapter(
    private var list: List<String>,
    private var index: Int,
    private val context: Context,
    private val onItemClick: (String) ->Unit,
): RecyclerView.Adapter<MultipleChoiceViewHolder>() {

    // Variable to keep track of the selected position
    var selectedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleChoiceViewHolder {
       return MultipleChoiceViewHolder(
           MultipleChoiceItemBinding.inflate(
               LayoutInflater.from(parent.context), parent, false
           ),
           context
           ,
           onItemClick
       )
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: MultipleChoiceViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data,this,index)

//        // Change the background color of the selected item
//        if (selectedPosition == position)
//            holder.itemView.setBackgroundColor(Color.parseColor("#DC746C")) // Selected color
//        else
//            holder.itemView.setBackgroundColor(Color.parseColor("#E49B83")) // Default color


    }
    fun updateData(newList: List<String>, newindex:Int) {
        list = newList
        index = newindex
        notifyDataSetChanged()
    }

    // Method to update the selected position
    fun updateSelectedPosition(newPosition: Int) {
        Log.d("MultipleChoiceAdapter", "Updating selected position: $newPosition")
        val oldPosition = selectedPosition
        selectedPosition = newPosition
        notifyItemChanged(oldPosition)
        notifyItemChanged(newPosition)
    }

}