//package com.onuremren.googleyemekapp
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.onuremren.googleyemekapp.databinding.DayMenuBinding
//import com.onuremren.googleyemekapp.model.MenuItem
//import kotlinx.android.synthetic.main.day_menu.view.*
//
//class ItemAdapter(private val dataSet: List<MenuItem>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
//
//    class ItemViewHolder(val view: DayMenuBinding): RecyclerView.ViewHolder(view.root) {
//
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//        val binding = DayMenuBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return ItemViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        holder.itemView.radioButton.setOnClickListener {
//            holder.view.radioGrup2.visibility = View.GONE
//        }
//
//    }
//
//    override fun getItemCount(): Int = dataSet.size
//}