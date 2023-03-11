package com.bme.drinksoderingchefend.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bme.drinksoderingchefend.R
import com.bme.drinksoderingchefend.databinding.TableListItemsBinding
import com.bme.drinksoderingchefend.repository.dto.Table
import com.bme.drinksoderingchefend.view.OrderActivity
import com.bme.drinksoderingchefend.viewModel.TablesActivityViewModel

class TablesRecyclerViewAdapter(val context: Context, val tables: List<Table>) :
    Adapter<TablesRecyclerViewAdapter.TablesViewHolder>() {

    private val viewModel: TablesActivityViewModel = TablesActivityViewModel(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablesViewHolder {
        return TablesViewHolder(
            TableListItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TablesViewHolder, position: Int) {
        holder.binding.tableNo.text = tables[position].tableNo.toString()

        if (tables[position].order!=null) {
            holder.binding.noOfDrinksOrder.text = tables[position].order?.size.toString()
            holder.binding.time.text = tables[position].time
            holder.binding.tableImage.setImageResource(R.drawable.fill_table)
        } else {
            holder.binding.noOfDrinksOrder.text = "0"
            holder.binding.time.text = context.getString(R.string.idel)
            holder.binding.tableImage.setImageResource(R.drawable.empty_table)
        }
    }

    override fun getItemCount(): Int {
        return tables.size
    }

    inner class TablesViewHolder(val binding: TableListItemsBinding) : ViewHolder(binding.root) {
        init {
            binding.cafeTable.setOnClickListener {
                viewModel.setOrderOfTable(tables[adapterPosition])
                context.startActivity(Intent(context, OrderActivity::class.java))
            }
        }
    }
}