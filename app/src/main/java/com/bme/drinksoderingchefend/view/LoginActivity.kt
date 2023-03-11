package com.bme.drinksoderingchefend.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bme.drinksoderingchefend.R
import com.bme.drinksoderingchefend.databinding.ActivityMainBinding
import com.bme.drinksoderingchefend.viewModel.LoginActivityViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = LoginActivityViewModel(this)

    }

    override fun onStart() {
        super.onStart()



        binding.signIn.setOnClickListener {
            LoginActivityViewModel.email = binding.emailEditText.editText?.text.toString()
            LoginActivityViewModel.password = binding.passwordEditText.editText?.text.toString()

            if (viewModel.signInValidation()) {
                startActivity(Intent(this, HomeActivity::class.java))
            }
            else{
                binding.emailEditText.error = "Failed"
            }
        }
    }
}