package com.bme.drinksoderingchefend.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.bme.drinksoderingchefend.repository.dto.TableRepository
import com.bme.drinksoderingchefend.repository.dto.Table
import com.bme.drinksoderingchefend.repository.dto.TableMock

class TablesActivityViewModel(context: Context) : ViewModel() {

    private val loginActivityViewModel : LoginActivityViewModel = LoginActivityViewModel(context)

    fun getTables(): MutableList<Table> {
        return TableRepository.listOfTables
    }
    fun setOrderOfTable(table: Table){
        OrderActivityViewModel.tables = table
    }
    fun signOut() {
        loginActivityViewModel.signOut()
    }
}