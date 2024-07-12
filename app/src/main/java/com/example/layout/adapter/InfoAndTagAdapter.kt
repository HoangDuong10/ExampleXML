package com.example.layout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layout.model.Info
import com.example.layout.databinding.ItemInfoBinding
import com.example.layout.databinding.ItemTagBinding

class InfoAndTagAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val TYPE_INFO: Int = 1
        const val TYPE_CATEGORY: Int = 2
    }

    private var listData: MutableList<Any> = mutableListOf()

    fun setData(list: List<Any>)  {
        this.listData = list.toMutableList()
        notifyDataSetChanged()
    }

    class InfoViewHolder(
        private val itemInfoBinding: ItemInfoBinding,
    ) : RecyclerView.ViewHolder(itemInfoBinding.root) {
        fun bind(info: Info, position : Int)  {
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

    class TagViewHolder(
        private val itemCategoryBinding: ItemTagBinding,
    ) : RecyclerView.ViewHolder(itemCategoryBinding.root) {
        fun bind(name: String)  {
            itemCategoryBinding.tvName.text = name
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (position < 6)
            {
                TYPE_INFO
            } else {
                TYPE_CATEGORY
            }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder =
        if (TYPE_INFO == viewType)
            {
                val itemInfoBinding = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                InfoViewHolder(itemInfoBinding)
            } else {
            val itemCategoryBinding = ItemTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            TagViewHolder(itemCategoryBinding)
        }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
    ) {
        if (holder is InfoViewHolder)
            {
                holder.bind(listData[position] as Info,position)
            } else if (holder is TagViewHolder)
            {
                holder.bind(listData[position] as String)
            }
    }
}