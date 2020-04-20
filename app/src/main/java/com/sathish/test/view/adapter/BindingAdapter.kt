package com.sathish.test.view.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

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
    Glide.with(view.context).load(imageURL)
        .load(imageURL)
        .into(view)
}
