package com.example.retrofitproject.app

import android.app.Application
import com.example.retrofitproject.database.room.ProductDatabase

class MainApp: Application() {
    val database by lazy { ProductDatabase.getInstance(this) }
}