package com.bme.drinksoderingchefend.viewModel.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {

    private val KEY = "Auth"
    private val FLAG = "Flag"

    var signIn: SharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
    private var signOut: SharedPreferences =
        context.getSharedPreferences(FLAG, Context.MODE_PRIVATE)

    companion object {

        private var INSTANCE: SharedPreferenceManager? = null

        fun getInstance(context: Context): SharedPreferenceManager? {
            if (INSTANCE == null) {
                INSTANCE = SharedPreferenceManager(context)
            }
            return INSTANCE
        }
    }

    fun signInValidation(email: String, password: String): Boolean {
        var validUserCredintial = false
        if (signIn.getString(email, " ").equals(password)) {
            validUserCredintial = true
            signOut.edit().putBoolean(FLAG, true).apply()
        }
        return validUserCredintial
    }


    fun signOut() {
        signOut.edit().clear().apply()
    }

    fun isSignedIn(): Boolean {
        return signOut.contains(FLAG)
    }

    fun defaultSignInDetails() {
        signIn.edit().putString("mycafe09@gmail.com", "MY1CAFE").apply()
    }
}