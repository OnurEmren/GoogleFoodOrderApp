package com.onuremren.googleyemekapp.db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.googleyemekapp.databinding.ShoppingItemBinding
import com.onuremren.googleyemekapp.model.ShoppingList
import com.onuremren.googleyemekapp.ui.OldOrderListFragmentDirections

class Adapter(var orderList: List<ShoppingList>): RecyclerView.Adapter<Adapter.ShoppingViewHolder>() {

    class ShoppingViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val inflater = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context))
        return ShoppingViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        holder.binding.textView2.text = orderList[position].shoppingList

        // TODO action to main page
        holder.itemView.setOnClickListener {
            val action = OldOrderListFragmentDirections.actionOldOrderListFragmentToListOldOrderFragment("old", orderList[position].id)
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return  orderList.size
    }
}