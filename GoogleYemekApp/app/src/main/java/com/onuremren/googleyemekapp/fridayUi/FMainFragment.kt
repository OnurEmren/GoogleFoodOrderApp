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
import com.onuremren.googleyemekapp.databinding.FragmentFMainBinding
import com.onuremren.googleyemekapp.model.OrderViewModel
import kotlinx.android.synthetic.main.fragment_f_main.*
import kotlinx.android.synthetic.main.fragment_t_main.*
import kotlinx.android.synthetic.main.fragment_t_main.subtotal

class FMainFragment : Fragment() {

    private var _binding: FragmentFMainBinding? = null
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
        _binding = FragmentFMainBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner

            viewModel = sharedViewModel

            fMainCourseFragment = this@FMainFragment
        }

        binding.mainRadio1S.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout1.visibility = View.VISIBLE
                binding.addMoreLayout3.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE
                binding.tvCount3.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount1.text = "1"
                sharedViewModel.resetOrder()

            }

        }


        binding.mainRadio2F.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout2.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout3.visibility = View.GONE
                sharedViewModel.resetOrder()
                binding.tvCount3.text = "1"
                binding.tvCount1.text = "1"
                binding.tvCount2.text = "1"
            }

        }



        binding.mainRadio3F.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.addMoreLayout3.visibility = View.VISIBLE
                binding.addMoreLayout1.visibility = View.GONE
                binding.addMoreLayout2.visibility = View.GONE

                sharedViewModel.resetOrder()
                binding.tvCount3.text = "1"
                binding.tvCount2.text = "1"
                binding.tvCount1.text = "1"

            }
        }



        sharedViewModel._setThreeMain.observe(viewLifecycleOwner, Observer {
            binding.tvCount3.text = it.toString()
        })

        sharedViewModel._setOneMain.observe(viewLifecycleOwner, Observer {
            binding.tvCount1.text = it.toString()

        })

        sharedViewModel._setTwoMain.observe(viewLifecycleOwner, Observer {
            binding.tvCount2.text = it.toString()

        })

    }


    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_FMainFragment_to_dayFragment)
    }

    fun goToNextScreen(){
        if (main_radio_1_s.isChecked || mainRadio2F.isChecked ||
            mainRadio3F.isChecked){
            findNavController().navigate(R.id.action_FMainFragment_to_FSideFragment)

        } else {
            Toast.makeText(requireContext(),"En az bir ana yemek seçmelisiniz.", Toast.LENGTH_LONG).show()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}