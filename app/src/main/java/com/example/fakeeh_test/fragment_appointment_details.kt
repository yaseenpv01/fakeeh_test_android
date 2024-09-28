package com.example.fakeeh_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_appointment_details.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_appointment_details : Fragment() {

    private lateinit var appointments: List<Appointment>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_appointment_details, container, false)

        val totalPriceTextView = view.findViewById<TextView>(R.id.totalPrice)
        val appointmentsRecyclerView = view.findViewById<RecyclerView>(R.id.appointmentsRecyclerView)

        // Calculate total price
        val totalPrice = appointments.sumOf { it.service.price }
        totalPriceTextView.text = "Total Price: $$totalPrice"

        // Setup RecyclerView for appointments
        appointmentsRecyclerView.layoutManager = LinearLayoutManager(context)
        appointmentsRecyclerView.adapter = AppointmentAdapter(appointments) { appointment ->

        }

        return view
    }


}