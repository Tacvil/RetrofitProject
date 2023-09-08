package com.example.retrofitproject.utilits

import androidx.room.TypeConverter

class StringTypeConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    fun toString(value: List<String>): String {
        return value.joinToString(",")
    }
}