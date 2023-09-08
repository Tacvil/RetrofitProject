package com.example.retrofitproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitproject.adapter.ProductAdapter
import com.example.retrofitproject.database.DatabaseRepository
import com.example.retrofitproject.database.room.ProductDatabase
import com.example.retrofitproject.database.room.ProductRepository
import com.example.retrofitproject.databinding.ActivityMainBinding
import com.example.retrofitproject.retrofit.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var productApi: ProductApi
    private lateinit var repository: DatabaseRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRcView()
        initRetrofitApi()
        initBd()

        CoroutineScope(Dispatchers.IO).launch {
            val allProductsApi = productApi.getAllProduct()
            repository.insert(allProductsApi.products)
            val listAllProducts = repository.getAllProducts()

            runOnUiThread {
                adapter.submitList(listAllProducts)
            }
        }
    }

    private fun initBd() {
        val dao = ProductDatabase.getInstance(applicationContext).getUserDao()
        repository = ProductRepository(dao)
    }

    private fun initRcView() {
        adapter = ProductAdapter()
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMain.adapter = adapter
    }

    private fun initRetrofitApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
        productApi = retrofit.create(ProductApi::class.java)
    }
}