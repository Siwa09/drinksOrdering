package com.bme.drinksoderingchefend.viewModel

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.bme.drinksoderingchefend.viewModel.utils.SharedPreferenceManager

class SplashActivityViewModel(val context: Context) : ViewModel() {
    private val viewModel: LoginActivityViewModel = LoginActivityViewModel(context)
    private val INSTANCE: SharedPreferenceManager = SharedPreferenceManager(context)


    fun isSignedIn(): Boolean{
        return viewModel.isSignedIn()
    }
    fun defaultSignInDetails(){
        INSTANCE.defaultSignInDetails()
    }
}