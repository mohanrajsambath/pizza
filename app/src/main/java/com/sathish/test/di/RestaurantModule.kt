package com.sathish.test.di

import com.sathish.test.domain.usecase.RestaurantUseCases
import com.mypratice.test.domain.usecase.RestaurantUseCasesImpl
import com.sathish.test.view.adapter.PizzaItemRecyclerViewAdapter
import com.sathish.test.viewmodel.PizzasListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 15-04-2020
 * File Name : RestaurantModule.kt
 * ClassName : RestaurantModule
 * Module Name : app
 * Desc : 
 */

val RestaurantModule = module {
    single { RestaurantUseCasesImpl(get()) }.bind(RestaurantUseCases::class)
    viewModel { PizzasListViewModel(get())  }
    factory { PizzaItemRecyclerViewAdapter() }
}