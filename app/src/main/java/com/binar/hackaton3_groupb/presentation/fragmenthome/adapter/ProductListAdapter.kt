package com.binar.hackaton3_groupb.presentation.fragmenthome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.binar.hackaton3_groupb.databinding.ItemListProductBinding
import com.binar.hackaton3_groupb.model.Product

class ProductListAdapter (private val onItemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductListViewHolder>(){

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    })
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(
            binding = ItemListProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onItemClick = onItemClick
        )
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(dataDiffer.currentList[position])
    }

    fun setData(data : List<Product>){
        dataDiffer.submitList(data)
        notifyItemRangeChanged(0,data.size)

    }

}

class ProductListViewHolder(
    private val binding : ItemListProductBinding,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product){
        with(binding) {
            ivProductImage.load(product.imageUrl)
            tvProductName.text = product.name
            tvProductPrice.text = product.price.toString()
            tvProductWeight.text = product.weightInKg.toString()
            root.setOnClickListener {
                onItemClick(product)
            }
        }
    }
}