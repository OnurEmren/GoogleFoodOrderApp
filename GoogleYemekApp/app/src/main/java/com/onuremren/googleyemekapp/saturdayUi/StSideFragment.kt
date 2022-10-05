package com.onuremren.googleyemekapp.saturdayUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentStSideBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_st_side.*
import kotlinx.android.synthetic.main.fragment_t_side.*


class StSideFragment : Fragment() {

    private var _binding: FragmentStSideBinding ?= null
    val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStSideBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            stSideMenuFragment = this@StSideFragment

        }

        binding.sideRadio1ST.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout1.visibility = View.VISIBLE
                binding.addMoreLayout3.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"


            }

        }

        binding.sideRadio2ST.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout2.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout3.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"
            }
        }

        binding.sideRadio3ST.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout3.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"


            }
        }


        sharedViewModel._setSide.observe(viewLifecycleOwner, Observer {
            binding.tvCount1.text = it.toString()
        })

        sharedViewModel._setSide2.observe(viewLifecycleOwner, Observer {
            binding.tvCount2.text = it.toString()
        })

        sharedViewModel._setSide3.observe(viewLifecycleOwner, Observer {
            binding.tvCount3.text = it.toString()
        })


        binding.button.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_stSideFragment_to_stMainFragment)
        }
    }


    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_stSideFragment_to_stMainFragment)
    }

    fun goToNextScreen(){
        if(sideRadio1ST.isChecked || sideRadio2ST.isChecked || sideRadio3ST.isChecked){
            findNavController().navigate(R.id.action_stSideFragment_to_tuesdayAccompanimentFragment)

        } else {
            Toast.makeText(requireContext(),"En az bir yardımcı yemek seçmelisiniz.",Toast.LENGTH_LONG).show()

        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}