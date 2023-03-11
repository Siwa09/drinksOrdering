package com.bme.drinksoderingchefend.viewModel


import android.content.Context
import androidx.lifecycle.ViewModel
import com.bme.drinksoderingchefend.repository.dto.Table
import com.bme.drinksoderingchefend.repository.dto.TableMock
import com.bme.drinksoderingchefend.repository.dto.TableRepository


class OrderActivityViewModel():ViewModel() {

    companion object {
        lateinit var tables: Table
        var isOrderCompleted = false
        var flag = 0
    }

    private fun orderCompleted(){
        if(tables.order?.size == flag){
            isOrderCompleted = true
        }
    }


    fun clearOrder(index: Int):Boolean {
        println(flag)
        orderCompleted()
        if(isOrderCompleted){
            TableRepository.listOfTables.get(index-1).order=null
        }
        return isOrderCompleted

    }
}