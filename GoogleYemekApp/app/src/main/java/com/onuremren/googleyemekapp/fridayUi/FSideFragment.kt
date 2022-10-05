package com.onuremren.googleyemekapp.fridayUi

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
import com.onuremren.googleyemekapp.databinding.FragmentFSideBinding
import com.onuremren.googleyemekapp.databinding.FragmentTSideBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_f_side.*
import kotlinx.android.synthetic.main.fragment_t_side.*


class FSideFragment : Fragment() {
    private var _binding: FragmentFSideBinding? = null
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
        _binding = FragmentFSideBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            fSideMenuFragment = this@FSideFragment
        }

        binding.sideRadio1.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout1.visibility = View.VISIBLE
                binding.addMoreLayout3.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE
                binding.addMoreLayout4.visibility = View.GONE
                sharedViewModel.resetSideOrder()
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"
                binding.tvCount4.text = "1"
                sharedViewModel.resetSideOrder()

            }

        }

        binding.sideRadio2.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout2.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout3.visibility = View.GONE
                binding.addMoreLayout4.visibility = View.GONE
                sharedViewModel.resetSideOrder()

                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"
                binding.tvCount4.text = "1"
            }

        }

        binding.sideRadio4.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout4.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE
                binding.addMoreLayout3.visibility = View.GONE
                sharedViewModel.resetSideOrder()

                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"
                binding.tvCount4.text = "1"

            }
        }


        sharedViewModel._setSide.observe(viewLifecycleOwner, Observer {
            binding.tvCount1.text = it.toString()

        })

        sharedViewModel._setSide2.observe(viewLifecycleOwner, Observer {
            binding.tvCount2.text = it.toString()
        })

        sharedViewModel._setSide4.observe(viewLifecycleOwner, Observer {
            binding.tvCount4.text = it.toString()
        })


        binding.button.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_FSideFragment_to_FMainFragment)
        }

    }
    fun cancelOrder(){
        sharedViewModel.resetOrder()

        findNavController().navigate(R.id.action_FSideFragment_to_FMainFragment)

    }

    fun goToNextScreen(){
        if (sideRadio1.isChecked || sideRadio2.isChecked || sideRadio4.isChecked){
            findNavController().navigate(R.id.action_FSideFragment_to_tuesdayAccompanimentFragment)

        } else{
            Toast.makeText(requireContext(),"En az bir yardımcı yemek seçmelisiniz.", Toast.LENGTH_LONG).show()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}