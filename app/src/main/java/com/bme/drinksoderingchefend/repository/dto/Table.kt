package com.bme.drinksoderingchefend.repository.dto


data class Table(
    val tableNo: Int,
    var time: String,
    var order: MutableList<Drink>?
)