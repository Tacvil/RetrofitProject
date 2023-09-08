package com.example.retrofitproject.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.retrofitproject.utilits.StringTypeConverter
import com.example.retrofitproject.database.models.ProductModel

@Database(entities = [ProductModel::class], version = 1)
@TypeConverters(StringTypeConverter::class)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getUserDao(): Dao

    companion object {

        @Volatile
        private var database: ProductDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ProductDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "database_product"
                ).build()
                database as ProductDatabase
            } else database as ProductDatabase
        }
    }
}