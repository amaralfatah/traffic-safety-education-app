package com.eduproject.trafficsafetyeducation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eduproject.trafficsafetyeducation.databinding.MultipleChoiceItemBinding

class MultipleChoiceAdapter(
    private var list: List<String>,
): RecyclerView.Adapter<MultipleChoiceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleChoiceViewHolder {
       return MultipleChoiceViewHolder(
           MultipleChoiceItemBinding.inflate(
               LayoutInflater.from(parent.context), parent, false
           ),
       )
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: MultipleChoiceViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }
    fun updateData(newList: List<String>) {
        list = newList
        notifyDataSetChanged()
    }

}