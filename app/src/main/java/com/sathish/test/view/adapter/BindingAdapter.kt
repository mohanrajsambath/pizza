package com.sathish.test.view.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mypratice.test.R
import com.sathish.test.model.IngredientsResponseApiItem
import java.text.FieldPosition

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :19-04-2020 
 * File Name : BindingAdapter.kt
 * ClassName : BindingAdapter
 * Module Name : app
 * Desc : 
 */

@BindingAdapter("image")
fun setImageUrl(view: ImageView, imageURL: String?) {
    if(!imageURL.isNullOrEmpty()) {
        Glide.with(view.context).load(imageURL)
            .placeholder(R.drawable.pizza_item)
            .into(view)
    }
}

@BindingAdapter("textPrice")
fun setPrice(view: TextView,text:Double?){
    text?.let {
        val price = "$$text".toString()
        view.text = price
    }
}

@BindingAdapter("pizzaPrice")
fun setPizzaBasePrice(view: TextView,text:Int?){
    text?.let {
        val price = "$$text".toString()
        view.text = price
    }
}

@BindingAdapter("Ingredient")
fun setIngredient(view: TextView, ingredient:ArrayList<IngredientsResponseApiItem>){

}

