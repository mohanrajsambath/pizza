package com.sathish.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sathish.test.domain.Result
import com.sathish.test.domain.usecase.AddToCartUseCases
import com.sathish.test.domain.usecase.RestaurantUseCases
import com.sathish.test.model.IngredientsResponseApiItem
import kotlinx.coroutines.launch

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 26-04-2020
 * File Name : IngredientViewModel.kt
 * ClassName : IngredientViewModel
 * Module Name : app
 * Desc : 
 */

class IngredientViewModel constructor(private val useCase: RestaurantUseCases,private val addToCartUseCases : AddToCartUseCases) :
    BaseViewModel() {
    private var ingredientList : MutableLiveData<List<IngredientsResponseApiItem>> = MutableLiveData()
    fun ingredientData() = ingredientList


     fun loadIngredientData(list:List<Int>) {
        viewModelScope.launch {
            when (val result = useCase.getIngredient()) {
                is Result.Success -> {
                    val data = result.data
                    ingredientList.value = data.sortedBy {
                        it.name
                    }
                    }

                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
                addToCartUseCases.addToCart(ingredientList.value!!,list)
            isLoading.set(false)
        }
    }

}