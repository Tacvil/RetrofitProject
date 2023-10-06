package com.example.retrofitproject.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.retrofitproject.data.local.model.ProductModel
import com.example.retrofitproject.data.local.database.ProductDatabase
import com.example.retrofitproject.data.repository.ProductRepository
import com.example.retrofitproject.data.remote.api.ProductApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    database: ProductDatabase,
    private var productApi: ProductApi
) : ViewModel() {
    private val repository = ProductRepository(database.getDao())

    suspend fun getProductsFromApi() = productApi.getProductsFromApi()

    suspend fun getProductsFromDatabase() = repository.getAllProducts()

    suspend fun insert(user: List<ProductModel>) = repository.insert(user)
}