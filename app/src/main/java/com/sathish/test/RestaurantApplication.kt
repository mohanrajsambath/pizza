package com.sathish.test

import android.app.Application
import com.sathish.test.di.RestaurantModule
import com.sathish.test.di.networkModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-04-2020
 * File Name : PizzaApplication.kt
 * ClassName : PizzaApplication
 * Module Name : app
 * Desc : 
 */

 class RestaurantApplication : Application() {
     override fun onCreate() {
         super.onCreate()
         configureDi()
     }

     private fun configureDi() {
          startKoin {
              androidLogger()
              androidContext(this@RestaurantApplication)
              modules(listOf(networkModel, RestaurantModule))
          }
     }

 }