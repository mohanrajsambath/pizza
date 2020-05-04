package com.sathish.test.domain.usecase

import com.sathish.test.domain.Result
import com.sathish.test.domain.Repository.RestaurantsRepository
import com.sathish.test.model.*

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
    RestaurantUseCases,AddToCartUseCases {
    override suspend fun getPizza(): Result<PizzaResponseApi> {
        return repository.getPizzaList()
    }

    override suspend fun getIngredient(): Result<IngredientsResponseApi> {
        return repository.getIngredientList()
    }

    override suspend fun getDrink(): Result<List<DrinksResponseApiItem>> {
        return repository.getDrinksList()
    }

    override fun addToCart(list: List<IngredientsResponseApiItem>, ingredientItems: List<Int>) {
        list.map { ingredient ->
            val id  = ingredientItems.find {
                it == ingredient.id
            }

            id?.let {
                ingredient.isAdded = true
            }

        }
    }
}