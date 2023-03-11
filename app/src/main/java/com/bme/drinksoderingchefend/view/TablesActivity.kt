package com.bme.drinksoderingchefend.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bme.drinksoderingchefend.view.adapters.TablesRecyclerViewAdapter
import com.bme.drinksoderingchefend.databinding.ActivityTablesBinding
import com.bme.drinksoderingchefend.viewModel.TablesActivityViewModel

class TablesActivity : AppCompatActivity() {


    lateinit var binding: ActivityTablesBinding
    lateinit var tablesActivityViewModel : TablesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTablesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tablesActivityViewModel = TablesActivityViewModel(this)
    }

    override fun onStart() {
        super.onStart()

        binding.signOut.setOnClickListener {
            tablesActivityViewModel.signOut()
            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.tablesRecyclerView.adapter = TablesRecyclerViewAdapter(this, tablesActivityViewModel.getTables())
        binding.tablesRecyclerView.layoutManager = GridLayoutManager(this, 2)

    }
}