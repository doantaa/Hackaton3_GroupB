package com.binar.hackaton3_groupb.presentation.fragmentdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import coil.load
import com.binar.hackaton3_groupb.R
import com.binar.hackaton3_groupb.databinding.FragmentDetailBinding
import com.binar.hackaton3_groupb.model.Product

class FragmentDetail : Fragment() {

    private lateinit var binding : FragmentDetailBinding

    private var count: Int = 1

    private val product: Product? by lazy{
        FragmentDetailArgs.fromBundle(arguments as Bundle).product
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProfileData()
        countingClickListener()
        backToPrevious()
    }

    private fun backToPrevious() {
        binding.ibArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun countingClickListener() {
        binding.icAdd.setOnClickListener{
            incrementCount()
        }
        binding.icRemove.setOnClickListener{
            decrementCount()
        }
    }

    private fun decrementCount() {
        count--
        if(count<=1){
            count=1;
        }
        binding.tvAmount.setText(count.toString())
        val total = product?.price!! * count
        binding.tvMenuPrice.setText(getString(R.string.idr, total))
    }

    private fun incrementCount() {
        count++
        binding.tvAmount.setText(count.toString())
        val total = product?.price!! * count
        binding.tvMenuPrice.setText(getString(R.string.idr, total))
    }

    private fun showProfileData() {
        if(product != null){
            binding.ivImgMenuDetail.load(product?.imageUrl)
            binding.tvMenuName.text = product?.name
            binding.tvSupplierName.text = product?.supplierName
            binding.tvRatings.text = product?.rating.toString()
            binding.tvMenuDesc.text = product?.description
            binding.tvMenuPrice.setText(getString(R.string.idr, product?.price))
        }
    }
}
