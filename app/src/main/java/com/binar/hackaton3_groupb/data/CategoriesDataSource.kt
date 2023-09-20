package com.binar.hackaton3_groupb.data

import com.binar.hackaton3_groupb.model.Categories

interface CategoriesDataSource {
    fun getCategories(): List<Categories>
}

class CategoriesDataSourceImpl() : CategoriesDataSource {
    override fun getCategories(): List<Categories> = listOf(
        Categories(
            name = "Groceries",
            imageUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_groceries.png"
        ),
        Categories(
            name = "Fruits",
            imageUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_fruits.png"
        ),

        Categories(
            name = "Spices",
            imageUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_spices.png"
        ),

        Categories(
            name = "Herbs",
            imageUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_herbs.png"
        ),

        Categories(
            name = "Seasoning",
            imageUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_seasoning.png"
        ),

        Categories(
            name = "Meat",
            imageUrl = "https://raw.githubusercontent.com/hermasyp/CH3-asset-code-challenge/master/categories/ic_category_meat.png"
        ),





        )
}