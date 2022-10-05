package com.onuremren.googleyemekapp.wednesdayUi

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
import com.onuremren.googleyemekapp.databinding.FragmentWednesdayMainBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_tuesday_main_course_menu.*
import kotlinx.android.synthetic.main.fragment_wednesday_main.*


class WednesdayMain : Fragment() {

    private var _binding : FragmentWednesdayMainBinding ?= null
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
        _binding = FragmentWednesdayMainBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            tuesdayMainCourseMenuFragment = this@WednesdayMain

            binding.mainRadio1W.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    binding.addMoreLayout1.visibility = View.VISIBLE
                    binding.addMoreLayout3.visibility = View.GONE
                    binding.addMoreLayout2.visibility = View.GONE
                    binding.addMoreLayout4.visibility = View.GONE
                    binding.tvCount3.text = "1"
                    binding.tvCount4.text = "1"
                    binding.tvCount2.text = "1"
                    sharedViewModel.resetOrder()

                }

            }


            binding.mainRadio2.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    binding.addMoreLayout2.visibility = View.VISIBLE
                    binding.addMoreLayout1.visibility = View.GONE
                    binding.addMoreLayout3.visibility = View.GONE
                    binding.addMoreLayout4.visibility = View.GONE
                    sharedViewModel.resetOrder()
                    binding.tvCount3.text = "1"
                    binding.tvCount4.text = "1"
                    binding.tvCount1.text = "1"
                }

            }



            binding.mainRadio3.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    binding.addMoreLayout3.visibility = View.VISIBLE
                    binding.addMoreLayout1.visibility = View.GONE
                    binding.addMoreLayout2.visibility = View.GONE
                    binding.addMoreLayout4.visibility = View.GONE

                    sharedViewModel.resetOrder()
                    binding.tvCount2.text = "1"
                    binding.tvCount4.text = "1"
                    binding.tvCount1.text = "1"

                }
            }

            binding.mainRadio4W.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    binding.addMoreLayout4.visibility = View.VISIBLE
                    binding.addMoreLayout1.visibility = View.GONE
                    binding.addMoreLayout2.visibility = View.GONE
                    binding.addMoreLayout3.visibility = View.GONE
                    sharedViewModel.resetOrder()
                    binding.tvCount2.text = "1"
                    binding.tvCount3.text = "1"
                    binding.tvCount1.text = "1"
                }

            }


            sharedViewModel._setOneMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount1.text = it.toString()
            })

            sharedViewModel._setTwoMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount2.text = it.toString()

            })

            sharedViewModel._setThreeMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount3.text = it.toString()
            })

            sharedViewModel._setFourMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount4.text = it.toString()
            })
        }
    }

    fun cancelOrder(){

        findNavController().navigate(R.id.action_wednesdayMain_to_dayFragment)
    }

    fun goToNextScreen(){
        if (mainRadio4W.isChecked || main_radio_3.isChecked ||
            main_radio_2.isChecked || mainRadio1W.isChecked){
            findNavController().navigate(R.id.action_wednesdayMain_to_wednesdaySideFragment)

        } else {
            Toast.makeText(requireContext(),"En az bir ana yemek seçmelisiniz.", Toast.LENGTH_LONG).show()
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}