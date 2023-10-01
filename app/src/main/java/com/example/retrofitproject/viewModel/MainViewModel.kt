package com.example.retrofitproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.retrofitproject.database.models.ProductModel
import com.example.retrofitproject.database.room.ProductDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(database: ProductDatabase) : ViewModel() {

    private val dao = database.getUserDao()

    fun insert(user: List<ProductModel>) = viewModelScope.launch {
        dao.insert(user)
    }

    suspend fun getAllProducts(): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            dao.getAllProducts()
        }
    }

    class MainViewModelFactory(private val database: ProductDatabase) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(database) as T
            }
            throw IllegalArgumentException("Unknown ViewModelClass: ${modelClass.simpleName}")
        }
    }


}