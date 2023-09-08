package com.example.retrofitproject.database

import com.example.retrofitproject.database.models.ProductModel

interface DatabaseRepository {

    suspend fun getAllProducts(): List<ProductModel>

    suspend fun insert(user: List<ProductModel>)
}