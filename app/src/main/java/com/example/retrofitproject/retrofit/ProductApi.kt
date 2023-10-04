package com.example.retrofitproject.retrofit

import retrofit2.http.GET

interface ProductApi {

    @GET("products?select=title,description,images,rating,price")
    suspend fun getProductsFromApi(): Products
}