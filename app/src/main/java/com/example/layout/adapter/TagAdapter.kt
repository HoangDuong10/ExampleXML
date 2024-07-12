package com.example.layout.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layout.databinding.ItemTagBinding

class TagAdapter(private var listTag : List<String>) :
    RecyclerView.Adapter<TagAdapter.TagViewHolder>() { class TagViewHolder(
        private val itemCategoryBinding: ItemTagBinding,
    ) : RecyclerView.ViewHolder(itemCategoryBinding.root) {
        fun bind(name: String)  {
            itemCategoryBinding.tvName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val itemTagBinding = ItemTagBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TagViewHolder(itemTagBinding)
    }

    override fun getItemCount(): Int {
        return listTag.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(listTag[position])
    }
}