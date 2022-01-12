package com.jeanbernuy.cookpad.core

import com.google.gson.GsonBuilder
import com.jeanbernuy.cookpad.core.AppConstants.BASE_URL
import com.jeanbernuy.cookpad.data.remote.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RestEngine {

    val restEngine by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}
