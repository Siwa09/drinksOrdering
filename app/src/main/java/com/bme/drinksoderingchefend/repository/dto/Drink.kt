package com.bme.drinksoderingchefend.repository.dto

data class Drink(
    val id: Int,
    val name: String,
    val drinksImage: Int,
    val price: Double,
    val orderQuantity : Int
    )