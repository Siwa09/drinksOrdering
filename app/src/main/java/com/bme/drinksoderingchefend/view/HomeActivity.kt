package com.bme.drinksoderingchefend.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bme.drinksoderingchefend.databinding.ActivityHomeBinding
import com.bme.drinksoderingchefend.view.adapters.MenuRecyclerViewAdapter

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.menuRecyclerView.adapter = MenuRecyclerViewAdapter(this)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
}