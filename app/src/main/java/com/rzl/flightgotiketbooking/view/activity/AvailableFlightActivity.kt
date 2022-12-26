package com.rzl.flightgotiketbooking.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rzl.flightgotiketbooking.R
import com.rzl.flightgotiketbooking.adapter.AdapterFlight
import com.rzl.flightgotiketbooking.databinding.ActivityAvailableFlightBinding
import com.rzl.flightgotiketbooking.model.DataFlight

class AvailableFlightActivity : AppCompatActivity() {

    lateinit var binding : ActivityAvailableFlightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_flight)


    }
}