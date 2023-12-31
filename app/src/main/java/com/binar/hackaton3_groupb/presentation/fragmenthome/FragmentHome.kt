package com.binar.hackaton3_groupb.presentation.fragmenthome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.hackaton3_groupb.R
import com.binar.hackaton3_groupb.data.CategoriesDataSource
import com.binar.hackaton3_groupb.data.CategoriesDataSourceImpl
import com.binar.hackaton3_groupb.data.ProductDataSourceImpl
import com.binar.hackaton3_groupb.databinding.FragmentHomeBinding
import com.binar.hackaton3_groupb.model.Categories
import com.binar.hackaton3_groupb.model.Product
import com.binar.hackaton3_groupb.presentation.fragmenthome.adapter.CategoriesListAdapter
import com.binar.hackaton3_groupb.presentation.fragmenthome.adapter.ProductListAdapter

class FragmentHome : Fragment() {


    private lateinit var binding: FragmentHomeBinding

    private val adapterProduct: ProductListAdapter by lazy {
        ProductListAdapter {
            navigateToFragmentDetailMenu(it)
        }
    }

    private fun navigateToFragmentDetailMenu(product: Product) {

        val action = FragmentHomeDirections.actionFragmentHome2ToFragmentDetail(product)
        findNavController().navigate(action)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showListCategories()
        showListProduct()
    }

    private fun showListCategories() {
        val categoryListAdapter = CategoriesListAdapter()
        binding.rvCategories.adapter = categoryListAdapter
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val categoriesDataSource: CategoriesDataSource = CategoriesDataSourceImpl()
        val categoriesList: List<Categories> = categoriesDataSource.getCategories()
        categoryListAdapter.setData(categoriesList)
    }

    private fun showListProduct() {
        binding.rvProduct.adapter = adapterProduct
        binding.rvProduct.layoutManager =
            GridLayoutManager(requireContext(), 2 )
        adapterProduct.setData(ProductDataSourceImpl().getProductData())

    }
}