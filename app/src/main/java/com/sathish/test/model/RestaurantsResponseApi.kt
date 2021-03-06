package com.sathish.test.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : RestaurantsResponseApi.kt
 * ClassName : RestaurantsResponseApi
 * Module Name : app
 * Desc : Bean Class
 */

data class PizzaResponseApi(
    @SerializedName("basePrice")
    val basePrice: Int = 0, // 4
    @SerializedName("pizzas")
    val pizzas: List<Pizza> = listOf()
)

data class Pizza(
    @SerializedName("imageUrl")
    val imageUrl: String = "", // https://doclerlabs.github.io/mobile-native-challenge/images/pizza_PNG44095.png
    @SerializedName("ingredients")
    val ingredients: List<Int> = listOf(),
    @SerializedName("name")
    val name: String = "", // Margherita
    @SerializedName("basePrice")
    var basePrice: Int = 0, // 4
    @SerializedName("ingredientsItems")
  val ingredientsItems : ArrayList<IngredientsResponseApiItem> = ArrayList()
) : Serializable

class IngredientsResponseApi : ArrayList<IngredientsResponseApiItem>()

data class IngredientsResponseApiItem(
    @SerializedName("id")
    val id: Int = 0, // 10
    @SerializedName("name")
    val name: String = "", // Tuna
    @SerializedName("price")
    val price: Double = 0.0 ,
    var isAdded : Boolean = false
) : Serializable

inline fun ArrayList<IngredientsResponseApiItem>.addItem( id: Int,find :(Int)->IngredientsResponseApiItem?){
    find(id).let {
        it?.let {
            add(it)
        }
    }
}


class DrinksResponseApi : ArrayList<DrinksResponseApiItem>()

data class DrinksResponseApiItem(
    @SerializedName("id")
    val id: Int = 0, // 5
    @SerializedName("name")
    val name: String = "", // Red Wine
    @SerializedName("price")
    val price: Double = 0.5 // 4
)


