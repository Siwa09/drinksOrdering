package com.bme.drinksoderingchefend.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bme.drinksoderingchefend.databinding.OrderListItemsBinding
import com.bme.drinksoderingchefend.repository.dto.Table
import com.bme.drinksoderingchefend.viewModel.OrderActivityViewModel

class OrderRecyclerViewAdapter : Adapter<OrderRecyclerViewAdapter.OrderViewHolder>() {
    var table: Table = OrderActivityViewModel.tables

    init {

        if (table.order == null) {
            table.order = mutableListOf()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        return OrderViewHolder(
            OrderListItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {

        holder.binding.orderedItemName.text = table.order!![position].name
        holder.binding.OrderedItemPrice.text = table.order!![position].price.toString()
        holder.binding.orderedItemLogo.setImageResource(table.order!![position].drinksImage)
        holder.binding.orderedQuantity.text = table.order!![position].orderQuantity.toString()


    }

    override fun getItemCount(): Int {
        return table.order!!.size
    }

    inner class OrderViewHolder(val binding: OrderListItemsBinding) : ViewHolder(binding.root) {
        init {
            binding.orderedItem.setOnClickListener {
                binding.orderStatus.isChecked = !binding.orderStatus.isChecked
                if (binding.orderStatus.isChecked) {
                    OrderActivityViewModel.flag++
                } else {
                    if (OrderActivityViewModel.flag != 0) {
                        OrderActivityViewModel.flag--

                    }
                }
            }
        }
    }
}