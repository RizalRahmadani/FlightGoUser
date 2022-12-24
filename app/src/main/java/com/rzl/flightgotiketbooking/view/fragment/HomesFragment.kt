package com.rzl.flightgotiketbooking.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.databinding.FragmentHomesBinding
import com.rzl.flightgotiketbooking.view.activity.AvailableFlightActivity


class HomesFragment : Fragment() {

    private var _binding : FragmentHomesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      _binding = FragmentHomesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            startActivity(Intent(requireActivity(),
                AvailableFlightActivity::class.java)
        )}
    }

}