package com.rzl.flightgotiketbooking.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.databinding.ActivityHomeBinding
import com.rzl.flightgotiketbooking.databinding.FragmentHomeBinding
import com.rzl.flightgotiketbooking.view.fragment.BookingFragment
import com.rzl.flightgotiketbooking.view.fragment.HomeFragment
import com.rzl.flightgotiketbooking.view.fragment.ProfileFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item_home -> replaceFragment(HomeFragment())
                R.id.item_booking -> replaceFragment(BookingFragment())
                R.id.item_profile -> replaceFragment(ProfileFragment())
                else -> {

                }

            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction  = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}