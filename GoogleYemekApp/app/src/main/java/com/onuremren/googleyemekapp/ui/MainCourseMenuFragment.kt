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
import com.onuremren.googleyemekapp.databinding.FragmentMainCourseMenuBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_main_course_menu.*
import kotlinx.android.synthetic.main.fragment_tuesday_main_course_menu.*
import kotlinx.android.synthetic.main.fragment_wednesday_main.*


class MainCourseMenuFragment : Fragment() {

    private var _binding: FragmentMainCourseMenuBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
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
        _binding = FragmentMainCourseMenuBinding.inflate(inflater,container,false)
        val root : View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.apply {

            lifecycleOwner = viewLifecycleOwner

            //From XML's viewModel
            viewModel = sharedViewModel

            tuesdayMainCourseMenuFragment = this@MainCourseMenuFragment



            binding.mainRadio1M.setOnCheckedChangeListener { compoundButton, b ->
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


            binding.mainRadio2M.setOnCheckedChangeListener { compoundButton, b ->
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

            binding.mainRadio4.setOnCheckedChangeListener { compoundButton, b ->
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

            sharedViewModel._setThreeMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount3.text = it.toString()
            })

            sharedViewModel._setOneMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount1.text = it.toString()

            })

            sharedViewModel._setFourMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount4.text = it.toString()
            })

            sharedViewModel._setTwoMain.observe(viewLifecycleOwner, Observer {
                binding.tvCount2.text = it.toString()

            })


        }

    }

    fun goToNextScreen() {
        if (mainRadio4.isChecked || mainRadio2M.isChecked ||
            mainRadio3.isChecked || mainRadio1M.isChecked){
            findNavController().navigate(R.id.action_entreeMenuFragment_to_sideMenuFragment)

        } else {
            Toast.makeText(requireContext(),"En az bir ana yemek seçmelisiniz.", Toast.LENGTH_LONG).show()
        }

    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_entreeMenuFragment_to_startOrderFragment)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}