package com.rzl.flightgotiketbooking.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.databinding.ActivityMainBinding
import com.rzl.flightgotiketbooking.view.fragment.*

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    lateinit var nav : NavigationBarView
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomesFragment())
        supportActionBar?.hide()

        bottomNav = binding.bottomNavigationView




        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_home -> {

                    loadFragment(HomesFragment())

                    return@setOnItemSelectedListener true
                }
                R.id.item_booking -> {
                    loadFragment(BookingFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.item_notification -> {
                    loadFragment(NotificationFragment())
                    return@setOnItemSelectedListener true
                }

                R.id.item_profile -> {
                    loadFragment(ProfileFragment())
                    return@setOnItemSelectedListener true
                }


                else -> {
                    false
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transcation = supportFragmentManager.beginTransaction()
        transcation.replace(R.id.mainContainer,fragment)
        transcation.addToBackStack(null)
        transcation.commit()
    }

}