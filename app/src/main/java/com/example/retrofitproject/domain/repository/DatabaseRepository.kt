package com.example.retrofitproject.domain.repository

import com.example.retrofitproject.data.local.model.ProductModel

interface DatabaseRepository {

    suspend fun getAllProducts(): List<ProductModel>

    suspend fun insert(user: List<ProductModel>)
}