package com.onuremren.googleyemekapp.tuesdayUi

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
import com.onuremren.googleyemekapp.databinding.FragmentTuesdaySideMenuBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_tuesday_side_menu.*


class TuesdaySideMenuFragment : Fragment() {
    private var _binding : FragmentTuesdaySideMenuBinding ?= null
    val binding get() = _binding!!
    private val sharedViewModel : OrderViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedViewModel.resetSideOrder()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTuesdaySideMenuBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner

            viewModel = sharedViewModel

            tuesdaySideMenuFragment = this@TuesdaySideMenuFragment


            binding.sideRadio1TD.setOnCheckedChangeListener { compoundButton, b ->
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

            binding.sideRadio2TD.setOnCheckedChangeListener { compoundButton, b ->
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

            binding.sideRadio3TS.setOnCheckedChangeListener { compoundButton, b ->
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

        }

        binding.button.setOnClickListener {
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_tuesdaySideMenuFragment_to_tuesdayMainCourseMenuFragment)
        }

    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_tuesdaySideMenuFragment_to_tuesdayMainCourseMenuFragment)

    }

    fun goToNextScreen(){
        if (sideRadio1TD.isChecked || sideRadio2TD.isChecked || sideRadio3TS.isChecked){
            findNavController().navigate(R.id.action_tuesdaySideMenuFragment_to_tuesdayAccompanimentFragment)

        } else{
            Toast.makeText(requireContext(),"En az bir yardımcı yemek seçmelisiniz.", Toast.LENGTH_LONG).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}