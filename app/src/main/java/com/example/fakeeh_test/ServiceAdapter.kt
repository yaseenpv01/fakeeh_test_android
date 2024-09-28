package com.example.fakeeh_test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ServicesAdapter(
    private val services: List<Service>,
    private val onServiceClicked: (Service) -> Unit
) : RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.bind(service, onServiceClicked)
    }

    override fun getItemCount(): Int = services.size

    class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(service: Service, onServiceClicked: (Service) -> Unit) {
            itemView.findViewById<TextView>(R.id.serviceName).text = service.name
            itemView.findViewById<TextView>(R.id.serviceCategory).text = service.category
            itemView.setOnClickListener { onServiceClicked(service) }
        }
    }
}
