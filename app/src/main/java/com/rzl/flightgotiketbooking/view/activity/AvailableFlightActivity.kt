package com.rzl.flightgotiketbooking.view.activity

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


        //Data available flight
        val listFlight = arrayListOf(
            DataFlight(R.drawable.garuda,"RP 1000.000"),
            DataFlight(R.drawable.garuda,"RP 1000.000"),
            DataFlight(R.drawable.garuda,"RP 1000.000"),
            DataFlight(R.drawable.garuda,"RP 1000.000"),
        )
        var adapterFlight = AdapterFlight(listFlight)
        val viewFlight = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvAvalaibleFlights.layoutManager = viewFlight
        binding.rvAvalaibleFlights.adapter = adapterFlight

    }
}