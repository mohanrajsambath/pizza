package com.sathish.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sathish.test.domain.Result
import com.sathish.test.domain.usecase.RestaurantUseCases
import com.mypratice.test.viewmodel.BaseViewModel
import com.sathish.test.model.IngredientsResponseApiItem
import com.sathish.test.model.Pizza
import kotlinx.coroutines.launch

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 15-04-2020
 * File Name : PizzasListViewModel.kt
 * ClassName : PizzasListViewModel
 * Module Name : app
 * Desc : 
 */

class PizzaViewModel constructor(private val useCase: RestaurantUseCases) : BaseViewModel() {

    private var pizzaList: MutableLiveData<List<Pizza>> = MutableLiveData()
    fun pizzaData() = pizzaList

    private var ingredientsResponseApiItem: Sequence<IngredientsResponseApiItem>? = null


    init {
        loadIngredientList()
        loadPizzaList()
    }

    private fun loadIngredientList() {
        viewModelScope.launch {
            when (val result = useCase.getIngredient()) {
                is Result.Success -> {
                    val data = result.data
                    ingredientsResponseApiItem = data.asSequence()
                }
                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
        }
    }

    private fun loadPizzaList() {
        viewModelScope.launch {
            when (val result = useCase.getPizza()) {
                is Result.Success -> {
                    val data = result.data
                    pizzaList.value = data.pizzas
                    data.pizzas.map {
                            pizza ->
                        /*pizza.ingredients.map {
                            val item = findItem(it)
                            pizza.ingredientsItems.add(item)
                        }*/
                    }
                }
                is Result.Error -> {
                    errorMessage.postValue(result.data)
                }
            }
            isLoading.set(false)
        }
    }

    private fun findItem(id: Int): IngredientsResponseApiItem {
        val result = ingredientsResponseApiItem?.find {
            it.id == id
        }
        return result!!
    }
}