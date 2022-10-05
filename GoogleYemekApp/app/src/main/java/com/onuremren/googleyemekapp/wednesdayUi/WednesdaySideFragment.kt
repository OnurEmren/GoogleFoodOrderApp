package com.onuremren.googleyemekapp.wednesdayUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentWednesdayMainBinding
import com.onuremren.googleyemekapp.databinding.FragmentWednesdaySideBinding
import com.onuremren.googleyemekapp.model.OrderViewModel


class WednesdaySideFragment : Fragment() {
    private var _binding : FragmentWednesdaySideBinding?= null
    val binding get() = _binding!!
    private val sharedViewModel : OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWednesdaySideBinding.inflate(inflater,container, false)
        val root: View = binding.root
        return root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            wednesdaySideMenuFragment = this@WednesdaySideFragment

        }

        binding.sideRadio1W.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout1.visibility = View.VISIBLE
                binding.addMoreLayout2.visibility = View.GONE
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"

                sharedViewModel.resetSideOrder()

            }

        }

        binding.sideRadio2W.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout2.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE

                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"


            }

        }


        sharedViewModel._setSide.observe(viewLifecycleOwner, Observer {
            binding.tvCount1.text = it.toString()
        })

        sharedViewModel._setSide2.observe(viewLifecycleOwner, Observer {
            binding.tvCount2.text = it.toString()
        })

        binding.button.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_wednesdaySideFragment_to_wednesdayMain)
        }
    }
    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_wednesdaySideFragment_to_wednesdayMain)

    }

    fun goToNextScreen(){
        findNavController().navigate(R.id.action_wednesdaySideFragment_to_tuesdayAccompanimentFragment)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}