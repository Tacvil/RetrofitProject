package com.example.retrofitproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.retrofitproject.R
import com.example.retrofitproject.database.models.ProductModel
import com.example.retrofitproject.databinding.ListItemBinding

class ProductAdapter : ListAdapter<ProductModel, ProductAdapter.Holder>(Comparator()) {

    class Holder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)

        fun setData(productModel: ProductModel) = with(binding) {
            textViewTitle.text = productModel.title
            textViewDescription.text = productModel.description
            textViewRating.text = productModel.rating.toString()
            val strPrice = "${productModel.price.toString()} $"
            textViewPrice.text = strPrice

            Glide.with(view)
                .load(productModel.images[0])
                .transform(RoundedCorners(20))
                .into(imageViewItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(getItem(position))
    }

    class Comparator : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }
    }
}