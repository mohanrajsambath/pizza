package com.sathish.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mypratice.test.viewmodel.BaseViewModel
import com.sathish.test.domain.Result
import com.sathish.test.domain.usecase.RestaurantUseCases
import com.sathish.test.model.DrinksResponseApi
import com.sathish.test.model.DrinksResponseApiItem
import com.sathish.test.model.IngredientsResponseApiItem
import com.sathish.test.model.Pizza
import kotlinx.coroutines.launch

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 21-04-2020
 * File Name : DrinksListViewModel.kt
 * ClassName : DrinksListViewModel
 * Module Name : app
 * Desc : 
 */

class DrinkViewModel constructor(private val useCase: RestaurantUseCases) : BaseViewModel() {

    private var drinksList: MutableLiveData<List<DrinksResponseApiItem>> = MutableLiveData()
    fun drinkData() = drinksList




    internal fun loadDrinksList() {
        viewModelScope.launch {
            when (val result = useCase.getDrink()) {
                is Result.Success -> {
                    val data = result.data
                    drinksList.value = data
                }
                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
            isLoading.set(false)
        }
    }
}