package com.example.fakeeh_test

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ServiceDao {
    @Query("SELECT * FROM services")
    fun getAllServices(): LiveData<List<Service>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(service: Service)
}

@Dao
interface DoctorDao {
    @Query("SELECT * FROM doctors WHERE serviceId = :serviceId")
    fun getDoctorsForService(serviceId: Int): LiveData<List<Doctor>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoctor(doctor: Doctor)
}
