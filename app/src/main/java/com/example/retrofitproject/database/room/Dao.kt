package com.example.retrofitproject.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitproject.database.models.ProductModel

@Dao
interface Dao {

    @Query("SELECT * from product_table")
    suspend fun getAllProducts(): List<ProductModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: List<ProductModel>)
}