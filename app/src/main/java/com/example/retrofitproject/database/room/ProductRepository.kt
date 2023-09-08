package com.example.retrofitproject.database.room

import com.example.retrofitproject.database.DatabaseRepository
import com.example.retrofitproject.database.models.ProductModel

class ProductRepository(private val userDao: Dao) : DatabaseRepository {

    override suspend fun getAllProducts(): List<ProductModel> {
        return userDao.getAllProducts()
    }

    override suspend fun insert(user: List<ProductModel>) {
        userDao.insert(user)
    }
}