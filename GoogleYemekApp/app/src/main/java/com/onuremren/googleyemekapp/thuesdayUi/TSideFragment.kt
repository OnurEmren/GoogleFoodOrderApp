package com.onuremren.googleyemekapp.thuesdayUi

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
import com.onuremren.googleyemekapp.databinding.FragmentTSideBinding
import com.onuremren.googleyemekapp.databinding.FragmentTuesdayAccompanimentBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_f_side.*
import kotlinx.android.synthetic.main.fragment_t_side.*

class TSideFragment : Fragment() {
    private var _binding: FragmentTSideBinding? = null
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
        _binding = FragmentTSideBinding.inflate(inflater,container,false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            tSideMenuFragment = this@TSideFragment
        }

        binding.sideRadio1T.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout1.visibility = View.VISIBLE
                binding.addMoreLayout3.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE
                binding.addMoreLayout4.visibility = View.GONE
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount3.text = "1"
                binding.tvCount4.text = "1"


                sharedViewModel.resetSideOrder()

            }

        }

        binding.sideRadio2S.setOnCheckedChangeListener { compoundButton, b ->
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

        binding.sideRadio4S.setOnCheckedChangeListener { compoundButton, b ->
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

        sharedViewModel._setSide3.observe(viewLifecycleOwner, Observer {
            binding.tvCount3.text = it.toString()

        })

        sharedViewModel._setSide4.observe(viewLifecycleOwner, Observer {
            binding.tvCount4.text = it.toString()

        })



        binding.button.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_TSideFragment_to_TMainFragment)
        }

    }
    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_TSideFragment_to_TMainFragment)

    }

    fun goToNextScreen(){
        if (sideRadio1T.isChecked || sideRadio2S.isChecked ||
                sideRadio4S.isChecked){
            findNavController().navigate(R.id.action_TSideFragment_to_tuesdayAccompanimentFragment)

        } else{
            Toast.makeText(requireContext(),"En az bir yardımcı yemek seçmelisiniz.",Toast.LENGTH_LONG).show()
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}