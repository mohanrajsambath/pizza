package com.sathish.test.di

import com.mypratice.test.BuildConfig
import com.sathish.test.data.repository.RestaurantService
import com.sathish.test.data.repository.RestaurantServiceImpl
import com.sathish.test.domain.Repository.RestaurantsRepository
import com.mypratice.test.utilis.Connectivity
import com.mypratice.test.utilis.ConnectivityImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
 * Project Name : Nenno's Pizza
 * Created by : R Sathish Kumar - Android Application Developer
 * Created on : 15-03-2020
 * File Name : RemoteModule.kt
 * ClassName : RemoteModule
 * Module Name : app
 * Desc : 
 */

val networkModel = module {
    single { provideRetrofit(get()) }
    factory { okHttpClient() }
    factory { provideRecipeService(get()) }
    single { ConnectivityImpl(androidContext()) }.bind(Connectivity::class)
    single { RestaurantServiceImpl(get(),get()) }.bind(RestaurantsRepository::class)
}


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun okHttpClient(): OkHttpClient {
    val interceptor: HttpLoggingInterceptor? = HttpLoggingInterceptor()
    interceptor!!.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}



fun provideRecipeService(retrofit: Retrofit): RestaurantService =
    retrofit.create(RestaurantService::class.java)