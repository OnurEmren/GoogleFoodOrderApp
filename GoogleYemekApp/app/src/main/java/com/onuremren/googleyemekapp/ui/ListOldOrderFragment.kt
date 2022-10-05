package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentListOldOrderBinding
import com.onuremren.googleyemekapp.db.Adapter
import com.onuremren.googleyemekapp.db.FoodDao
import com.onuremren.googleyemekapp.db.FoodDatabase
import com.onuremren.googleyemekapp.model.OrderViewModel
import com.onuremren.googleyemekapp.model.ShoppingList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list_old_order.view.*
import kotlinx.android.synthetic.main.fragment_order_detail.*

class ListOldOrderFragment : Fragment() {

    private var _binding : FragmentListOldOrderBinding ?= null
    val binding get() = _binding!!
    private val sharedViewModel: OrderViewModel by activityViewModels()
    private lateinit var foodDao: FoodDao
    private lateinit var foodDatabase: FoodDatabase
    private val mDisposable = CompositeDisposable()
    private lateinit var adapter : Adapter
    var listFromMain: ShoppingList? = null
    private val args: ListOldOrderFragmentArgs by navArgs()

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
        _binding = FragmentListOldOrderBinding.inflate(inflater,container,false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener { save(view) }
        binding.orderAgain.setOnClickListener { orderRepeat() }
        binding.deleteButton.setOnClickListener { delete(view) }


        arguments?.let {
            val info = ListOldOrderFragmentArgs.fromBundle(it).info
            binding.saveButton.visibility = View.INVISIBLE
            binding.deleteButton.visibility = View.VISIBLE
            binding.orderAgain.visibility = View.VISIBLE
            if (info == "old"){
                val selectedId = ListOldOrderFragmentArgs.fromBundle(it).id
                mDisposable.add(foodDao.getListById(selectedId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponseWithOldList))
            } else {
                binding.saveButton.visibility = View.VISIBLE
                binding.deleteButton.visibility = View.INVISIBLE
                binding.orderAgain.visibility = View.INVISIBLE

            }
        }

        binding.order.text = args.info

    }

    private fun delete(view: View) {
        listFromMain?.let {
            mDisposable.add(foodDao.delete(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse))
        }
    }

    private fun handleResponseWithOldList(shoppingList: ShoppingList){
        listFromMain = shoppingList
        binding.order.setText(shoppingList.shoppingList)
    }

    private fun save(view: View) {
        val listTitle = binding.order.text.toString()


        val mListe = ShoppingList(listTitle)
        mDisposable.add(foodDao.insert(mListe)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }
    private fun orderRepeat(){
        ShareCompat.IntentBuilder.from(requireActivity())
            .setChooserTitle("Siparişi Gönder")
            .setType("text/plain")
            .startChooser()

        Toast.makeText(requireContext(),"Sipariş Oluşturuldu",Toast.LENGTH_SHORT).show()
      findNavController().navigate(R.id.action_listOldOrderFragment_to_startOrderFragment)
    }


    private fun handleResponse(){
        val action = ListOldOrderFragmentDirections.actionListOldOrderFragmentToOldOrderListFragment("",0)
        Navigation.findNavController(requireView()).navigate(action)
    }


}