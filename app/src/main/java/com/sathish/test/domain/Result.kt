package com.sathish.test.domain

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 15-04-2020
 * File Name : Result.kt
 * ClassName : Result
 * Module Name : app
 * Desc : 
 */

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val data: String) : Result<Nothing>()

}