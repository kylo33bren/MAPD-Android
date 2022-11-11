package com.example.brendanRodrigues_MAPD11_Optional_Assignment.interfaces

import com.example.brendanRodrigues_MAPD11_Optional_Assignment.model.ApiModel
import retrofit2.Call
import retrofit2.http.GET

//Interface for getting info
interface RetroServiceInterface {
    @GET("products/category/fragrances")
    fun getFragrances(): Call<ApiModel>
}