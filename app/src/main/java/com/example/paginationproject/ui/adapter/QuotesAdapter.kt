package com.example.paginationproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationproject.databinding.ItemQuotesBinding
import com.example.paginationproject.models.ResultModel
import com.example.paginationproject.ui.adapter.QuotesAdapter.QuotesViewHolder

class QuotesAdapter() : PagingDataAdapter<ResultModel,QuotesViewHolder>(diffUtilComparator){

    companion object {
        private val diffUtilComparator = object : DiffUtil.ItemCallback<ResultModel>(){
            override fun areItemsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class QuotesViewHolder(val binding: ItemQuotesBinding) : RecyclerView.ViewHolder(binding.root){
    }
    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int){
        val item = getItem(position)
        if (item != null) {
            holder.binding.authorName = item.author
            holder.binding.quoteOfDay = item.content
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        return QuotesViewHolder(
            ItemQuotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }
}