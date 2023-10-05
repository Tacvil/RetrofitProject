package com.example.retrofitproject.data.repository

import com.example.retrofitproject.domain.repository.DatabaseRepository
import com.example.retrofitproject.data.local.model.ProductModel
import com.example.retrofitproject.data.local.dao.Dao

class ProductRepository(private val dao: Dao) : DatabaseRepository {

    override suspend fun getAllProducts(): List<ProductModel> = dao.getAllProducts()

    override suspend fun insert(user: List<ProductModel>) = dao.insert(user)
}