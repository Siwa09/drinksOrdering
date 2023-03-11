package com.bme.drinksoderingchefend.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.bme.drinksoderingchefend.viewModel.utils.SharedPreferenceManager

class LoginActivityViewModel(context: Context):ViewModel(){

    private val INSTANCE: SharedPreferenceManager = SharedPreferenceManager(context)

    companion object {
        lateinit var email: String
        lateinit var password: String
    }

    fun signInValidation(): Boolean {
        return INSTANCE.signInValidation(email, password)
    }

    fun signOut() {
        INSTANCE.signOut()
    }

    fun isSignedIn(): Boolean {
        return INSTANCE.isSignedIn()
    }



}