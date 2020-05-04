package com.sathish.test.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mypratice.test.databinding.IngredientItemBinding
import com.sathish.test.model.IngredientsResponseApiItem

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :25-04-2020 
 * File Name : IngredientItemRecyclerViewAdapter.kt
 * ClassName : IngredientItemRecyclerViewAdapter
 * Module Name : app
 * Desc : 
 */

class IngredientItemRecyclerViewAdapter :
    RecyclerView.Adapter<IngredientItemRecyclerViewAdapter.ViewHolder>() {

    private var items: MutableList<IngredientsResponseApiItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: IngredientItemBinding =
            IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount()= items.size


    fun update(data: List<IngredientsResponseApiItem>) {
        this.items.apply {
            val size = size
            addAll(size, data)
            notifyItemChanged(size)
        }
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        return holder.binding(items[position])

    }

    class ViewHolder(private val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root) {
      fun binding(item:IngredientsResponseApiItem){
          binding.itemDetails = item
          binding.executePendingBindings()
      }
    }
}