package com.example.fakeeh_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppointmentAdapter(
    private val appointments: List<Appointment>,
    private val onCancelClicked: (Appointment) -> Unit
) : RecyclerView.Adapter<AppointmentAdapter.AppointmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_appointment, parent, false)
        return AppointmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment = appointments[position]
        holder.bind(appointment, onCancelClicked)
    }

    override fun getItemCount(): Int = appointments.size

    class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(appointment: Appointment, onCancelClicked: (Appointment) -> Unit) {
            itemView.findViewById<TextView>(R.id.serviceName).text = appointment.service.name
            itemView.findViewById<TextView>(R.id.servicePrice).text = appointment.service.price.toString()
            itemView.findViewById<Button>(R.id.cancelButton).setOnClickListener {
                onCancelClicked(appointment)
            }
        }
    }
}
