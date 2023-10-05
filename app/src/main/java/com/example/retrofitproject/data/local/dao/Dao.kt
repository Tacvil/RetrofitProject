package com.example.retrofitproject.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitproject.data.local.model.ProductModel

@Dao
interface Dao {

    @Query("SELECT * from product_table")
    suspend fun getAllProducts(): List<ProductModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: List<ProductModel>)
}