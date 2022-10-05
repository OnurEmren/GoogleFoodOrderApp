package com.onuremren.googleyemekapp.tuesdayUi

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.onuremren.googleyemekapp.R
import com.onuremren.googleyemekapp.databinding.FragmentTuesdayAccompanimentBinding
import com.onuremren.googleyemekapp.model.OrderViewModel


class TuesdayAccompanimentFragment : Fragment() {

    private var _binding: FragmentTuesdayAccompanimentBinding? = null
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
        _binding = FragmentTuesdayAccompanimentBinding.inflate(inflater,container,false)
        val root: View = binding.root
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            tuesdayAccompanimentFragment = this@TuesdayAccompanimentFragment



            binding.garRadio1TD.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    binding.addMoreLayout1.visibility = View.VISIBLE
                    binding.addMoreLayout3.visibility = View.GONE
                    binding.addMoreLayout2.visibility = View.GONE
                    binding.addMoreLayout4.visibility = View.GONE
                    sharedViewModel.resetGarOrder()
                    binding.tvCount1.text = "1"
                    binding.tvCount2.text = "1"
                    binding.tvCount3.text = "1"
                    binding.tvCount4.text = "1"

                }

            }


            binding.garRadio2TD.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    binding.addMoreLayout2.visibility = View.VISIBLE
                    binding.addMoreLayout1.visibility = View.GONE
                    binding.addMoreLayout3.visibility = View.GONE
                    binding.addMoreLayout4.visibility = View.GONE
                    sharedViewModel.resetGarOrder()
                    binding.tvCount1.text = "1"
                    binding.tvCount2.text = "1"
                    binding.tvCount3.text = "1"
                    binding.tvCount4.text = "1"
                }

            }



            binding.garRadio3TD.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    binding.addMoreLayout3.visibility = View.VISIBLE
                    binding.addMoreLayout1.visibility = View.GONE
                    binding.addMoreLayout2.visibility = View.GONE
                    binding.addMoreLayout4.visibility = View.GONE
                    sharedViewModel.resetGarOrder()
                    binding.tvCount1.text = "1"
                    binding.tvCount2.text = "1"
                    binding.tvCount3.text = "1"
                    binding.tvCount4.text = "1"

                }
            }

            binding.garRadio4TD.setOnCheckedChangeListener { compoundButton, b ->
                if (b) {
                    binding.addMoreLayout4.visibility = View.VISIBLE
                    binding.addMoreLayout1.visibility = View.GONE
                    binding.addMoreLayout2.visibility = View.GONE
                    binding.addMoreLayout3.visibility = View.GONE
                    sharedViewModel.resetGarOrder()
                    binding.tvCount1.text = "1"
                    binding.tvCount2.text = "1"
                    binding.tvCount3.text = "1"
                    binding.tvCount4.text = "1"

                }

            }

            sharedViewModel._setGar.observe(viewLifecycleOwner, Observer {
                binding.tvCount1.text = it.toString()
            })
            sharedViewModel._setGar2.observe(viewLifecycleOwner, Observer {
                binding.tvCount2.text = it.toString()
            })

            sharedViewModel._setGar3.observe(viewLifecycleOwner, Observer {
                binding.tvCount3.text = it.toString()
            })
            sharedViewModel._setGar4.observe(viewLifecycleOwner, Observer {
                binding.tvCount4.text = it.toString()
            })
        }

    }


    fun cancelOrder(){


        var alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle("Dikkat")
        alertDialogBuilder.setMessage("Siparişi iptal etmek istediğinizden emin misiniz? ?")
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setPositiveButton("Evet", DialogInterface.OnClickListener { dialog, which ->
            sharedViewModel.resetOrder()
            findNavController().navigate(R.id.action_tuesdayAccompanimentFragment_to_dayFragment)

            dialog.cancel()
        } )
        alertDialogBuilder.setNegativeButton("Hayır", DialogInterface.OnClickListener { dialog, which ->
            // Do nothing
        } )
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()


    }
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_tuesdayAccompanimentFragment_to_tuesdayCheckOutFragment)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}