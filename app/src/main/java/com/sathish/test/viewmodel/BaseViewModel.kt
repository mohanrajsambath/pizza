package com.mypratice.test.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :15-03-2020
 * File Name : BaseViewModel.kt
 * ClassName : BaseViewModel
 * Module Name : app
 * Desc : 
 */
abstract class BaseViewModel : ViewModel(){

    // ERROR message
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    // Loading indicator
    val isLoading = ObservableField(true)

}