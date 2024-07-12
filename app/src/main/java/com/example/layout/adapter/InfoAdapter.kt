package com.example.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layout.databinding.ItemInfoBinding
import com.example.layout.model.Info

class InfoAdapter(private val listInfo: List<Info>) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {


    inner class InfoViewHolder(
        private val itemInfoBinding: ItemInfoBinding,
    ) : RecyclerView.ViewHolder(itemInfoBinding.root) {
        fun bind(info: Info)  {
            itemInfoBinding.tvTitle.text = info.title
            itemInfoBinding.tvValue.text = info.value
            when (position) {
                0 -> {
                    itemInfoBinding.ivIncrease.visibility = View.VISIBLE
                    itemInfoBinding.tvPercentIncreased.text = "1%"
                }
                1 -> {
                    itemInfoBinding.ivIncrease.visibility = View.VISIBLE
                    itemInfoBinding.tvPercentIncreased.text = "1%"
                }
                else -> {
                    itemInfoBinding.ivIncrease.visibility = View.GONE
                    itemInfoBinding.tvPercentIncreased.visibility = View.GONE
                }
            }


        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ): InfoAdapter.InfoViewHolder {
        val itemInfoBinding = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return InfoViewHolder(itemInfoBinding)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(listInfo[position])
    }


    override fun getItemCount(): Int = listInfo.size


}