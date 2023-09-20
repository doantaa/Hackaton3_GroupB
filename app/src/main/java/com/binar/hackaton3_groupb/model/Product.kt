package com.binar.hackaton3_groupb.model

import java.util.UUID

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Int,
    val weightInKg: Double,
    val supplierName: String,
    val rating: Double,
    val description: String,
    val imageUrl: String
)
