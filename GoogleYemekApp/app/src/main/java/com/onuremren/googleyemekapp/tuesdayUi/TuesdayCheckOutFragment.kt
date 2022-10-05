package com.onuremren.googleyemekapp.tuesdayUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.android.material.snackbar.Snackbar
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentTuesdayCheckOutBinding
import com.onuremren.googleyemekapp.db.FoodDao
import com.onuremren.googleyemekapp.db.FoodDatabase
import com.onuremren.googleyemekapp.model.OrderViewModel

import kotlinx.android.synthetic.main.fragment_tuesday_check_out.*


class TuesdayCheckOutFragment : Fragment() {

    private var _binding : FragmentTuesdayCheckOutBinding ?= null
    private val binding get() = _binding!!

    private val orderViewModel : OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTuesdayCheckOutBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = orderViewModel
            checkoutFragment = this@TuesdayCheckOutFragment

        }

        binding.saveOrderButton.setOnClickListener {
            val mainOrder = orderListTV.text.toString()
            val sideOrder = binding.textView3.text.toString()
            val accoOrder = binding.textView4.text.toString()

            val listOrder = arrayListOf<String>(mainOrder,sideOrder,accoOrder)

            binding.entreeSelection.text = listOrder.toString()
            val action = TuesdayCheckOutFragmentDirections.actionTuesdayCheckOutFragmentToListOldOrderFragment(
                listOrder.toString()
            )
            Navigation.findNavController(it).navigate(action)

        }

    }


    fun cancelOrder(){

        orderViewModel.resetOrder()
        findNavController().navigate(R.id.action_tuesdayCheckOutFragment_to_startOrderFragment)
    }

    fun submitOrder(){
        share()
        Snackbar.make(binding.root,"Sipariş Oluşturuldu",Snackbar.LENGTH_LONG).show()
        orderViewModel.resetOrder()
        findNavController().navigate(R.id.action_tuesdayCheckOutFragment_to_startOrderFragment)
    }

    private fun share(){
        ShareCompat.IntentBuilder.from(requireActivity())
            .setChooserTitle("Siparişi Gönder")
            .setType("text/plain")
            .startChooser()
    }



}