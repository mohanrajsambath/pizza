package com.sathish.test.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mypratice.test.R
import com.mypratice.test.databinding.PizzaItemsBinding
import com.sathish.test.model.IngredientsResponseApiItem
import com.sathish.test.model.Pizza
import com.sathish.test.view.PizzaListFragmentDirections

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : PizzaItemRecyclerViewAdapter.kt
 * ClassName : PizzaItemRecyclerViewAdapter
 * Module Name : app
 * Desc : 
 */

class PizzaItemRecyclerViewAdapter :
    RecyclerView.Adapter<PizzaItemRecyclerViewAdapter.ViewHolder>() {
    private var items: MutableList<Pizza> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding: PizzaItemsBinding =
            PizzaItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    fun update(data: List<Pizza>) {
        this.items.apply {
            val size = size
            addAll(size, data)
            notifyItemChanged(size)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(private val binding: PizzaItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Pizza) {
            binding.itemDetails = item
            binding.executePendingBindings()
            binding.clickListener = View.OnClickListener {
                val id  =  item.ingredients
                val bundle = bundleOf(
                    "name" to item.name,
                    "image" to item.imageUrl,
                    "id" to id )
               it?.findNavController()?.navigate(R.id.action_ingredient_list,bundle)

            }
        }
    }
}


