package com.example.fakeeh_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_service_details.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_service_details : Fragment() {

    private lateinit var service: Service

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_service_details, container, false)

        view.findViewById<TextView>(R.id.serviceName).text = service.name
        view.findViewById<TextView>(R.id.serviceCategory).text = service.category
        view.findViewById<TextView>(R.id.servicePrice).text = service.price.toString()
        return view
    }


}