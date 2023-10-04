package com.example.retrofitproject.viewModel

import androidx.lifecycle.ViewModel
import com.example.retrofitproject.database.models.ProductModel
import com.example.retrofitproject.database.room.ProductDatabase
import com.example.retrofitproject.retrofit.ProductApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    database: ProductDatabase,
    private var productApi: ProductApi
) : ViewModel() {

    private val dao = database.getUserDao()

    suspend fun getProductsFromApi() = productApi.getProductsFromApi()

    suspend fun getProductsFromDatabase() = dao.getAllProducts()

    suspend fun insert(user: List<ProductModel>) = dao.insert(user)
}