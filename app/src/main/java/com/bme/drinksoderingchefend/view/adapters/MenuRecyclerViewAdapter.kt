package com.bme.drinksoderingchefend.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bme.drinksoderingchefend.R
import com.bme.drinksoderingchefend.databinding.MenuListItemsBinding
import com.bme.drinksoderingchefend.view.TablesActivity

class MenuRecyclerViewAdapter(val context:Context) : Adapter<MenuRecyclerViewAdapter.MenuViewHolder>(){

    private val labels = listOf("Orders","Drinks")
    private val images = listOf(R.drawable.beer, R.drawable.empty_table)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(MenuListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.binding.menuItemLabel.text = labels[holder.adapterPosition]
        holder.binding.menuItemImage.setImageResource(images[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
       return labels.size
    }

    inner class MenuViewHolder(val binding: MenuListItemsBinding): RecyclerView.ViewHolder(binding.root){
        init {
            binding.menuItem.setOnClickListener{
                context.startActivity(Intent(context,TablesActivity::class.java))
            }
        }
    }
}