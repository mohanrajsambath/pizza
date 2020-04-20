package com.sathish.test.data.repository

import com.sathish.test.data.endPoint.EndPointsPath
import com.sathish.test.model.DrinksResponseApi
import com.sathish.test.model.IngredientsResponseApi
import com.sathish.test.model.IngredientsResponseApiItem
import com.sathish.test.model.PizzaResponseApi
import retrofit2.Response
import retrofit2.http.GET

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 15-04-2020
 * File Name : Remote.kt
 * ClassName : Remote
 * Module Name : app
 * Desc : 
 */

interface RestaurantService {

    @GET(EndPointsPath.Restaurant.PIZZAS)
     suspend fun getPizzasList() : Response <PizzaResponseApi>

    @GET(EndPointsPath.Restaurant.INGREDIENTS)
    suspend fun getIngredientsList() : Response<IngredientsResponseApi>

    @GET(EndPointsPath.Restaurant.DRINKS)
    suspend fun getDrinksList() : Response<DrinksResponseApi>
}