package com.bme.drinksoderingchefend.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bme.drinksoderingchefend.R
import com.bme.drinksoderingchefend.databinding.ActivityOrderBinding
import com.bme.drinksoderingchefend.view.adapters.OrderRecyclerViewAdapter
import com.bme.drinksoderingchefend.viewModel.OrderActivityViewModel

class OrderActivity : AppCompatActivity() {

    lateinit var binding: ActivityOrderBinding
    lateinit var viewModel: OrderActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding =  ActivityOrderBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel = OrderActivityViewModel()
    }

    override fun onStart() {
        super.onStart()
        binding.orderedTableNo.text = OrderActivityViewModel.tables.tableNo.toString()
        binding.orderRecyclerView.adapter = OrderRecyclerViewAdapter()
        binding.orderRecyclerView.layoutManager = GridLayoutManager(this, 2)

        binding.orderCompleted.setOnClickListener{
            if(!viewModel.clearOrder(OrderActivityViewModel.tables.tableNo)){
                Toast.makeText(this,"All the Order are not Served",Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this,TablesActivity::class.java))
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}