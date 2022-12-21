package com.rzl.flightgotiketbooking.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.adapter.AdapterSlideShow
import com.rzl.flightgotiketbooking.databinding.FragmentHomeBinding
import com.rzl.flightgotiketbooking.model.DataSlideShow
import com.rzl.flightgotiketbooking.view.activity.AvailableFlightActivity
import com.rzl.flightgotiketbooking.view.activity.HomeActivity


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

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        binding.btnSearchFlight.setOnClickListener {
////
////            val intent = Intent(this@HomeFragment.requireContext(), AvailableFlightActivity::class.java)
////            startActivity(intent)
////
////
//////            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_availableFlightFragment)
//////            fragmentManager?.beginTransaction().apply {
//////                replace(R.id.frame_layout, AvailableFlightFragment, AvailableFlightFragment::class.java.simpleName)
//////                    .addToBackStack(null)
//////                    .commit()
//////            }
//////            val intent = Intent(this@HomeFragment.requireContext(), ContentActivity::class.java)
//////            startActivity(intent)
//////            val availableFlightFragment : AvailableFlightFragment
//////            val transaction: FragmentTransaction = FragmentManager!!.beginTransaction()
//////            transaction.replace(R.id.frame_layout,AvailableFlightFragment)
//////            transaction.commit()
////
////        }
//
////        view?.findViewById<View>(R.id.selfcarebut)?.setOnClickListener {
////            val intent = Intent(requireContext(),SelfcareActivity::class.java)
////            startActivity(intent)
////        }
//        binding.imgNotif.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_to_notificationFragment)
//        }
//        binding.imgUser.setOnClickListener{
//            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
//        }
//
//
//

//
//
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.findViewById<View>(R.id.btn_search_flight)?.setOnClickListener {
            val intent = Intent(requireContext(),AvailableFlightActivity::class.java)
            startActivity(intent)
        }


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

    private fun loadFragment(fragment: Fragment) {
        val transcation = parentFragmentManager.beginTransaction()
        transcation.replace(R.id.mainContainer,fragment)
        transcation.addToBackStack(null)
        transcation.commit()
    }

}