package com.bme.drinksoderingchefend.repository.dto

import com.bme.drinksoderingchefend.R
import java.time.LocalTime

class TableMock {
    companion object {
        fun getTables(): MutableList<Table> {
            return mutableListOf(
                Table(1, LocalTime.now().toString(), null),
                Table(
                    2,
                    LocalTime.now().toString(),
                    mutableListOf(Drink(2, "Soft Drink", R.drawable.soft_drink, 3.0, 1))
                ),
                Table(3, LocalTime.now().toString(), null),
                Table(4, LocalTime.now().toString(), null),
                Table(5, LocalTime.now().toString(), null),
                Table(6, LocalTime.now().toString(), null),
                Table(7, LocalTime.now().toString(), null),
                Table(8, LocalTime.now().toString(), null),
                Table(9, LocalTime.now().toString(), null),
                Table(
                    10, LocalTime.now().toString(), mutableListOf(
                        Drink(1, "Beer", R.drawable.beer, 4.0, 3),
                        Drink(2, "Soft Drink", R.drawable.soft_drink, 3.0, 1)
                    )
                )
            )
        }
    }
}