package com.example.brendanRodrigues_MAPD11_Optional_Assignment.model

data class ApiModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)