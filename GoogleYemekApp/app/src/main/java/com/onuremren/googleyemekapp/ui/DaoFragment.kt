package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentDaoragmentBinding
import com.onuremren.googleyemekapp.db.Adapter
import com.onuremren.googleyemekapp.model.DaoViewModel


class DaoFragment  : Fragment() {

    private var _binding : FragmentDaoragmentBinding ?= null
    val binding get() = _binding!!

    lateinit var viewModel :DaoViewModel
    private  lateinit var fragmentAdapter: Adapter

    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val layoutPosition = viewHolder.layoutPosition
            val selectedArt = fragmentAdapter.orderList[layoutPosition]
            viewModel.deleteOrder(selectedArt)

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDaoragmentBinding.inflate(inflater,container,false)
        val root = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToObservers()
        binding.orderRecyclerView.adapter = fragmentAdapter
        binding.orderRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        ItemTouchHelper(swipeCallBack).attachToRecyclerView(binding.orderRecyclerView)

    }

    private fun subscribeToObservers() {
        viewModel.orderList.observe(viewLifecycleOwner, Observer {
            fragmentAdapter.orderList = it
        })
    }



}