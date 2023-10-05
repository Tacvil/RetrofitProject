package com.example.retrofitproject.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitproject.presentation.adapters.ProductAdapter
import com.example.retrofitproject.databinding.ActivityMainBinding
import com.example.retrofitproject.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRcView()

        lifecycleScope.launch {
            viewModel.insert(viewModel.getProductsFromApi().products)
            adapter.submitList(viewModel.getProductsFromDatabase())
        }
    }

    private fun initRcView() {
        adapter = ProductAdapter()
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMain.adapter = adapter
    }

}