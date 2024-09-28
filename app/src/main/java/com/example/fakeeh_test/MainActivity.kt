package com.example.fakeeh_test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val db = AppDatabase.getDatabase(applicationContext)
        val serviceDao = db.serviceDao()
        val doctorDao = db.doctorDao()

        lifecycleScope.launch {


            serviceDao.insertService(Service(0, "Doctor Consultation", "General Physician", 100.0))
            serviceDao.insertService(Service(0, "Diagnostics", "Blood Test", 50.0))
            serviceDao.insertService(Service(0, "Health Packages", "Annual Health Checkup", 300.0))

            doctorDao.insertDoctor(Doctor(0, "Dr. Smith", "General Physician", 10, true, 1))
            doctorDao.insertDoctor(Doctor(0, "Dr. John", "Cardiologist", 15, true, 1))
        }
    }
}