package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentOrderDetailBinding
import com.onuremren.googleyemekapp.db.Adapter
import com.onuremren.googleyemekapp.db.FoodDao
import com.onuremren.googleyemekapp.db.FoodDatabase
import com.onuremren.googleyemekapp.model.OrderViewModel
import com.onuremren.googleyemekapp.model.ShoppingList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class OldOrderListFragment : Fragment() {
    private var _binding: FragmentOrderDetailBinding?=null
    private val binding get()  = _binding!!
    private lateinit var foodDao: FoodDao
    private lateinit var foodDatabase: FoodDatabase
    lateinit var sharedViewModel: OrderViewModel
    private val mDisposable = CompositeDisposable()
    private lateinit var adapter: Adapter

//    private val swipeCallBack = object : ItemTouchHelper.SimpleCallback(0,
//        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
//        override fun onMove(
//            recyclerView: RecyclerView,
//            viewHolder: RecyclerView.ViewHolder,
//            target: RecyclerView.ViewHolder
//        ): Boolean {
//            return true
//        }
//        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//            val layoutPosition = viewHolder.layoutPosition
//            val selectedOrder = adapter.orderList[layoutPosition]
//            sharedViewModel.deleteOrder(selectedOrder)
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        foodDatabase = Room.databaseBuilder(requireContext(),FoodDatabase::class.java,"orderDatabase").build()
        foodDao = foodDatabase.shoppingDao()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOrderDetailBinding.inflate(inflater,container,false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getFromSQL()


    }

    private fun getFromSQL() {
        mDisposable.add(foodDao.getListWithNameAndId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(shoppingList: List<ShoppingList>){
        binding.orderRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = Adapter(shoppingList)
        binding.orderRecyclerView.adapter = adapter


    }

}