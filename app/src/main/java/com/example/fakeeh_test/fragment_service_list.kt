package com.example.fakeeh_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_service_list.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_service_list : Fragment() {


    private lateinit var servicesAdapter: ServicesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_service_list, container, false)

        val servicesRecyclerView = view.findViewById<RecyclerView>(R.id.servicesRecyclerView)
        servicesRecyclerView.layoutManager = LinearLayoutManager(context)

        // Example services
        val services = listOf(
            Service(1, "Doctor Consultation", "Dr.A",100.0),
            Service(2, "Doctor Consultation", "Dr.A",150.0),
            Service(3, "Diagnostics","Dr.A", 50.0),
            Service(4, "Diagnostics","Dr.A", 200.0),
            Service(5, "Health Packages","Dr.A", 300.0),
            Service(6, "Health Packages","Dr.A", 250.0)
        )

        servicesAdapter = ServicesAdapter(services) { selectedService ->


        }

        servicesRecyclerView.adapter = servicesAdapter
        return view


    }


}