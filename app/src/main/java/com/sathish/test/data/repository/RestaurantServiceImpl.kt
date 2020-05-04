package com.sathish.test.data.repository

import com.sathish.test.domain.Result
import com.sathish.test.domain.Repository.RestaurantsRepository
import com.sathish.test.utilis.Connectivity
import com.sathish.test.model.*

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 15-04-2020
 * File Name : PizzaServiceImpl.kt
 * ClassName : PizzaServiceImpl
 * Module Name : app
 * Desc : 
 */


class RestaurantServiceImpl constructor(
    private val restaurantService: RestaurantService,
    private val connectivity: Connectivity
) : RestaurantsRepository {
    override suspend fun getPizzaList(): Result<PizzaResponseApi> {
        return if (connectivity.isNetworkAvailable()) {
            getPizzaData()
        } else return Result.Error("No Internet Connection")
    }

    override suspend fun getIngredientList(): Result<IngredientsResponseApi> {
        return if (connectivity.isNetworkAvailable()) {
            getIngredientsData()
        } else return Result.Error("No Internet Connection")
    }

    private suspend fun getIngredientsData(): Result<IngredientsResponseApi> {
        val response = restaurantService.getIngredientsList()

        if (response.isSuccessful) {
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.errorBody().toString())
    }

    private suspend fun getPizzaData(): Result<PizzaResponseApi> {
        val response = restaurantService.getPizzasList()
        if (response.isSuccessful) {
            val basePrice =response.body()!!.basePrice
            response.body()?.pizzas?.map {
                it.basePrice = basePrice
            }
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.errorBody().toString())
    }

    override suspend fun getDrinksList(): Result<List<DrinksResponseApiItem>> {
        return if (connectivity.isNetworkAvailable()) {
            getDrinkData()
        } else return Result.Error("No Internet Connection")
    }

    private suspend fun getDrinkData(): Result<List<DrinksResponseApiItem>> {
        val response = restaurantService.getDrinksList()
        if (response.isSuccessful) {
            response.body()?.let {
                return Result.Success(it)
            }
        }
        return Result.Error(response.errorBody().toString())
    }
    
}

  
