package com.sathish.test.domain.usecase

import com.sathish.test.domain.Result
import com.sathish.test.domain.Pizzas
import com.sathish.test.model.DrinksResponseApi
import com.sathish.test.model.IngredientsResponseApi
import com.sathish.test.model.PizzaResponseApi
import retrofit2.Response

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : RestaurantUseCases.kt
 * ClassName : RestaurantUseCases
 * Module Name : app
 * Desc : 
 */
 interface RestaurantUseCases {
    suspend fun getPizza(): Result<PizzaResponseApi>
    suspend fun getIngredient(): Result<IngredientsResponseApi>
    suspend fun getDrink(): Result<DrinksResponseApi>
}