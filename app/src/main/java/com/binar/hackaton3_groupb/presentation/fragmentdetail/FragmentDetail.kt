package com.binar.hackaton3_groupb.presentation.fragmentdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import coil.load
import com.binar.hackaton3_groupb.R
import com.binar.hackaton3_groupb.databinding.FragmentDetailBinding
import com.binar.hackaton3_groupb.model.Product

class FragmentDetail : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val product: Product? by lazy{
        FragmentMenuDetailArgs.fromBundle(arguments as Bundle).menu
    }

    companion object{
        const val IDR = "IDR"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root

        binding.icAdd.setOnClickListener(

        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProfileData()
    }

    private fun showProfileData() {
        if(product != null){
            binding.ivImgMenuDetail.load(product?.imageUrl)
            binding.tvMenuName.text = product?.name
            binding.tvSupplierName.text = product?.supplierName
            binding.tvRatings.text = product?.rating.toString()
            binding.tvMenuDesc.text = product?.description
            binding.tvMenuPrice.text = "$IDR ${product?.price?.toInt() * binding.tvAmount.text.toIn}"
        }
    }
}


}