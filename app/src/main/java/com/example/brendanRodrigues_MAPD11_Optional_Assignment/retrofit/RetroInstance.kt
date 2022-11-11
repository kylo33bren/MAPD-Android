package com.example.brendanRodrigues_MAPD11_Optional_Assignment.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//linking url to app
class RetroInstance {
    companion object{
        var BASE_URL = "https://dummyjson.com/"
        fun getRetroInstance(): Retrofit? {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}