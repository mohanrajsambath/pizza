package com.sathish.test.domain.Repository

import com.sathish.test.domain.Result
import com.sathish.test.model.*

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : RestaurantsRepository.kt
 * ClassName : RestaurantsRepository
 * Module Name : app
 * Desc : 
 */

interface RestaurantsRepository {
 suspend fun  getPizzaList(): Result<PizzaResponseApi>
 suspend fun  getIngredientList() : Result<IngredientsResponseApi>
 suspend fun  getDrinksList(): Result<List<DrinksResponseApiItem>>
}