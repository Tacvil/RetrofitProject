package com.example.retrofitproject.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.retrofitproject.database.models.ProductModel
import com.example.retrofitproject.utilits.StringTypeConverter

@Database(entities = [ProductModel::class], version = 1)
@TypeConverters(StringTypeConverter::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getUserDao(): Dao
}