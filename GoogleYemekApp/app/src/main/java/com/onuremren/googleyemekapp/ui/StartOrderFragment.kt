package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.onuremren.googleyemekapp.viewPager.SliderItemAdapter
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentStartOrderBinding


class StartOrderFragment : Fragment() {

    private var _binding: FragmentStartOrderBinding ?= null
    private val binding get() = _binding!!

    lateinit var viewPager: ViewPager
    lateinit var viewPagerAdapter: SliderItemAdapter
    lateinit var imageList: List<Int>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStartOrderBinding.inflate(inflater,container,false)
        val root : View = binding.root




        binding.oldOrderButton.setOnClickListener {

            val action = StartOrderFragmentDirections.actionStartOrderFragmentToOldOrderListFragment("",0)
            Navigation.findNavController(it).navigate(action)
        }
        binding.startOrderBtn.setOnClickListener {
            findNavController().navigate(R.id.action_startOrderFragment_to_dayFragment)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}