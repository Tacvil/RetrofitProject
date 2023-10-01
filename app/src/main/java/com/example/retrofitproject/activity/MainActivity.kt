package com.example.retrofitproject.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitproject.adapter.ProductAdapter
import com.example.retrofitproject.app.MainApp
import com.example.retrofitproject.databinding.ActivityMainBinding
import com.example.retrofitproject.retrofit.ProductApi
import com.example.retrofitproject.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var productApi: ProductApi

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModel.MainViewModelFactory((application as MainApp).database))[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRcView()
        initRetrofitApi()

        CoroutineScope(Dispatchers.IO).launch {
            val allProductsApi = productApi.getAllProduct()
            viewModel.insert(allProductsApi.products)
            val listAllProducts = viewModel.getAllProducts()

            runOnUiThread {
                adapter.submitList(listAllProducts)
            }
        }
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