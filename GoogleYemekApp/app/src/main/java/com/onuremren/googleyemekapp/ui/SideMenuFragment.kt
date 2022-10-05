package com.onuremren.googleyemekapp.ui

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
import com.onuremren.googleyemekapp.databinding.FragmentSideMenuBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_side_menu.*


class SideMenuFragment : Fragment() {

    private var _binding : FragmentSideMenuBinding ?= null
    private val binding get() = _binding!!

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSideMenuBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            sideMenuFragment = this@SideMenuFragment
        }
        binding.sideRadio1M.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout1.visibility = View.VISIBLE
                binding.addMoreLayout3.visibility = View.GONE
                binding.addMoreLayout4.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"


            }

        }

        binding.sideRadio3M.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout3.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout4.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"
            }
        }

        binding.sideRadio4M.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout4.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout3.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"


            }
        }


        sharedViewModel._setSide.observe(viewLifecycleOwner, Observer {
            binding.tvCount1.text = it.toString()
        })

        sharedViewModel._setSide3.observe(viewLifecycleOwner, Observer {
            binding.tvCount3.text = it.toString()
        })

        sharedViewModel._setSide4.observe(viewLifecycleOwner, Observer {
            binding.tvCount4.text = it.toString()
        })


        binding.sideClear.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_sideMenuFragment_to_entreeMenuFragment)
        }



    }

    fun goToNextScreen(){
        if (sideRadio2M.isChecked || sideRadio1M.isChecked || sideRadio3M.isChecked || sideRadio4M.isChecked){
            findNavController().navigate(R.id.action_sideMenuFragment_to_tuesdayAccompanimentFragment)

        } else{
            Toast.makeText(requireContext(),"En az bir yardımcı yemek seçmelisiniz.", Toast.LENGTH_LONG).show()

        }
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_sideMenuFragment_to_entreeMenuFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}