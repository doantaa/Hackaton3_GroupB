package com.binar.hackaton3_groupb.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID
@Parcelize
data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Int,
    val weightInKg: Double,
    val supplierName: String,
    val rating: Double,
    val description: String,
    val imageUrl: String
): Parcelable
