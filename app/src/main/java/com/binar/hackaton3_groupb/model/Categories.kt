package com.binar.hackaton3_groupb.model

import java.util.UUID

data class Categories(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val imageUrl: String
)
