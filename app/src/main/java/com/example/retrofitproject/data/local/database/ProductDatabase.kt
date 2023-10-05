package com.example.retrofitproject.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.retrofitproject.data.local.dao.Dao
import com.example.retrofitproject.data.local.model.ProductModel
import com.example.retrofitproject.utils.StringTypeConverter

@Database(entities = [ProductModel::class], version = 1)
@TypeConverters(StringTypeConverter::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getDao(): Dao
}