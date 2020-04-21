package com.sathish.test.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mypratice.test.databinding.DrinkItemsBinding
import com.sathish.test.model.DrinksResponseApiItem

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :21-04-2020 
 * File Name : DrinkItemRecyclerViewAdapter.kt
 * ClassName : DrinkItemRecyclerViewAdapter
 * Module Name : app
 * Desc : 
 */
class DrinkItemRecyclerViewAdapter :
    RecyclerView.Adapter<DrinkItemRecyclerViewAdapter.ViewHolder>() {
    private var items: MutableList<DrinksResponseApiItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: DrinkItemsBinding =
            DrinkItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount() = items.size

    fun update(data: List<DrinksResponseApiItem>) {
        this.items.apply {
            val size = size
            addAll(size, data)
            notifyItemChanged(size)
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: DrinkItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(drinksResponseApi: DrinksResponseApiItem) {

        }

    }
}