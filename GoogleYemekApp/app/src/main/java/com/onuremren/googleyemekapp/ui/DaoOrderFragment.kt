package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentListOldOrderBinding
import com.onuremren.googleyemekapp.db.Adapter
import com.onuremren.googleyemekapp.model.DaoViewModel


class DaoOrderFragment(val orderAdapter: Adapter): Fragment(R.layout.dao_order_fragment) {
    lateinit var viewModel: DaoViewModel
    private var fragmentBinding : FragmentListOldOrderBinding ?= null


    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedOrder = orderAdapter.orderList[layoutPosition]
                viewModel.deleteOrder(selectedOrder)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToObservers()

        viewModel = ViewModelProvider(requireActivity()).get(DaoViewModel::class.java)
        val binding = FragmentListOldOrderBinding.bind(view)
        fragmentBinding = binding

    }

    private fun subscribeToObservers() {
        viewModel.orderList.observe(viewLifecycleOwner, Observer {
            orderAdapter.orderList = it
        })
    }
}