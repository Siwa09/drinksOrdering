package com.bme.drinksoderingchefend.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bme.drinksoderingchefend.R
import com.bme.drinksoderingchefend.viewModel.SplashActivityViewModel

class SplashActivity : AppCompatActivity() {

    lateinit var viewModel: SplashActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = SplashActivityViewModel(this)

        Handler().postDelayed({
            if (!viewModel.isSignedIn()) {
                viewModel.defaultSignInDetails()
                startActivity(Intent(this, LoginActivity::class.java))

            }
            else{
                startActivity(Intent(this, HomeActivity::class.java))

            }
        }, 2000L)
    }


    override fun onPause() {
        super.onPause()
        finish()
    }

}