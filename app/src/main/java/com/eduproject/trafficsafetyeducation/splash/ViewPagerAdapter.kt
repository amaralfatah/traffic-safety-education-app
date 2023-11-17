package com.eduproject.trafficsafetyeducation.splash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.eduproject.trafficsafetyeducation.R

class ViewPagerAdapter(
    private var title: List<String>,
    private var details: List<String>,
    private var lottieFiles: List<String>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle : TextView = itemView.findViewById(R.id.tvTitle)
        val itemDetails : TextView = itemView.findViewById(R.id.tvAbout)
        val itemLottie : LottieAnimationView = itemView.findViewById(R.id.animLottie)

        init {
            itemLottie.setOnClickListener { v : View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetails.text = details[position]

        // Memeriksa nilai i dan menentukan file Lottie yang sesuai
        when (position + 1) {
            1 -> holder.itemLottie.setAnimation(R.raw.on_boarding_1)
            2 -> holder.itemLottie.setAnimation(R.raw.on_boarding_2)
            3 -> holder.itemLottie.setAnimation(R.raw.on_boarding_3)
        }
    }



    override fun getItemCount(): Int {
        return title.size
    }
}
