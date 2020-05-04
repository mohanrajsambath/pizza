package com.sathish.test.utilis

import android.content.Context
import android.net.ConnectivityManager
import com.sathish.test.utilis.Connectivity

/*
 * Project Name : prac
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on :31-03-2020 
 * File Name : ConnectivityImpl.kt
 * ClassName : ConnectivityImpl
 * Module Name : app
 * Desc : 
 */
@Suppress("DEPRECATION")
class ConnectivityImpl(private val context: Context) : Connectivity {
    override fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}