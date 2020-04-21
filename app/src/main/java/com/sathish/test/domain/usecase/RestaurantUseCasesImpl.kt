package com.mypratice.test.domain.usecase

import com.sathish.test.domain.Result
import com.sathish.test.domain.Repository.RestaurantsRepository
import com.sathish.test.domain.usecase.RestaurantUseCases
import com.sathish.test.model.DrinksResponseApi
import com.sathish.test.model.DrinksResponseApiItem
import com.sathish.test.model.IngredientsResponseApi
import com.sathish.test.model.PizzaResponseApi

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : RestaurantUseCasesImpl.kt
 * ClassName : RestaurantUseCasesImpl
 * Module Name : app
 * Desc : 
 */

class RestaurantUseCasesImpl(private val repository: RestaurantsRepository) :
    RestaurantUseCases {
    override suspend fun getPizza(): Result<PizzaResponseApi> {
        return repository.getPizzaList()
    }

    override suspend fun getIngredient(): Result<IngredientsResponseApi> {
        return repository.getIngredientList()
    }

    override suspend fun getDrink(): Result<List<DrinksResponseApiItem>> {
        return repository.getDrinksList()
    }
}