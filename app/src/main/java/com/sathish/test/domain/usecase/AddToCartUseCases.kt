package com.sathish.test.domain.usecase

import com.sathish.test.model.IngredientsResponseApiItem

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :26-04-2020 
 * File Name : AddToCartUseCases.kt
 * ClassName : AddToCartUseCases
 * Module Name : app
 * Desc : 
 */
interface AddToCartUseCases {
    fun addToCart(list:List<IngredientsResponseApiItem>, ingredientItems:List<Int> )
}