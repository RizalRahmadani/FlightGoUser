package com.rzl.flightgotiketbooking.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.adapter.AdapterSlideShow
import com.rzl.flightgotiketbooking.databinding.FragmentHomeBinding
import com.rzl.flightgotiketbooking.model.DataSlideShow
import com.rzl.flightgotiketbooking.view.activity.AvailableFlightActivity


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearchFlight.setOnClickListener { startActivity(Intent(requireActivity(),AvailableFlightActivity::class.java))}


        //Data slide show
        val listSlideShow = arrayListOf(
            DataSlideShow(R.drawable.slide_show),
            DataSlideShow(R.drawable.slide_show),
            DataSlideShow(R.drawable.slide_show),
            DataSlideShow(R.drawable.slide_show),
            DataSlideShow(R.drawable.slide_show),
            DataSlideShow(R.drawable.slide_show),
        )
        var adapterSlide = AdapterSlideShow(listSlideShow)
        val viewFlight = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        binding.rvSlideShow.layoutManager = viewFlight
        binding.rvSlideShow.adapter = adapterSlide
    }

}