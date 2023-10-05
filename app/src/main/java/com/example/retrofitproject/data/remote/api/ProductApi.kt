package com.example.retrofitproject.data.remote.api

import com.example.retrofitproject.data.local.model.Products
import retrofit2.http.GET

interface ProductApi {

    @GET("products?select=title,description,images,rating,price")
    suspend fun getProductsFromApi(): Products
}