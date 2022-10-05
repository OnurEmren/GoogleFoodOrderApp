package com.onuremren.googleyemekapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentDayBinding

class DayFragment : Fragment() {

    private var _binding : FragmentDayBinding ?= null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentDayBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button7.setOnClickListener {
            findNavController().navigate(R.id.action_dayFragment_to_entreeMenuFragment)
        }

        binding.tuesdayButton.setOnClickListener {
            findNavController().navigate(R.id.action_dayFragment_to_tuesdayMainCourseMenuFragment)
        }

        binding.wednesdayButton.setOnClickListener {
            findNavController().navigate(R.id.action_dayFragment_to_wednesdayMain)
        }

        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_dayFragment_to_TMainFragment)
        }

        binding.friday.setOnClickListener {
            findNavController().navigate(R.id.action_dayFragment_to_FMainFragment)
        }

        binding.saturday.setOnClickListener {
            findNavController().navigate(R.id.action_dayFragment_to_stMainFragment)
        }
    }


}