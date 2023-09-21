package com.binar.hackaton3_groupb.presentation.fragmenthome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.binar.hackaton3_groupb.R
import com.binar.hackaton3_groupb.data.ProductDataSourceImpl
import com.binar.hackaton3_groupb.presentation.fragmenthome.adapter.ProductListAdapter
import com.binar.hackaton3_groupb.databinding.FragmentHomeBinding
import com.binar.hackaton3_groupb.model.Product

class FragmentHome : Fragment() {


    private lateinit var binding: FragmentHomeBinding

    private val adapterProduct: ProductListAdapter by lazy {
        ProductListAdapter {
            navigateToFragmentDetailMenu(it)
        }
    }

    private fun navigateToFragmentDetailMenu(product: Product) {
        val action = FragmentHomeDirections.navigateToFragmentDetail(product)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showListProduct()
    }

    private fun showListProduct() {
//        binding.rvProduct.adapter = adapterProduct
//        binding.rvProduct.layoutManager =
//            GridLayoutManager(requireContext(), 2 )
//        adapterProduct.setData(ProductDataSourceImpl().getProductData())

    }


}