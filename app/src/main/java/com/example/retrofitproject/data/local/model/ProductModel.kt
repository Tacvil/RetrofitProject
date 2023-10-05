package com.example.retrofitproject.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class ProductModel(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "price")
    val price: Int?,
    @ColumnInfo(name = "rating")
    val rating: Float?,
    @ColumnInfo(name = "images")
    val images: List<String>
)
