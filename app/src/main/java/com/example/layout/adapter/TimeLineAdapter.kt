package com.example.layout.adapter

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.layout.R
import com.example.layout.databinding.ItemTimeLineBinding
import com.example.layout.model.TimeLineUser

class TimeLineAdapter(private val timeLine : List<TimeLineUser>, private val context: Context) : RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder>() {
    inner class TimeLineViewHolder(private val timeLineBinding: ItemTimeLineBinding) : RecyclerView.ViewHolder(timeLineBinding.root){
        fun bind(timeLine : TimeLineUser){
            val spannableString = SpannableString(timeLine.title)
            val redColor = ContextCompat.getColor(context, R.color.green)
            spannableString.setSpan(ForegroundColorSpan(redColor), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            timeLineBinding.tvTime.text = timeLine.date.toString()
            timeLineBinding.tvTitle.text = spannableString
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeLineViewHolder {
        val workBinding = ItemTimeLineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TimeLineViewHolder(workBinding)
    }

    override fun getItemCount(): Int {
        return timeLine.size
    }

    override fun onBindViewHolder(holder: TimeLineViewHolder, position: Int) {
        holder.bind(timeLine[position])
    }
}