package com.example.mypharmacy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mypharmacy.model.HospitalModel
import com.example.mypharmacy.repository.HospitalRepository

class HospitalViewModel : ViewModel(){
    private val hospitalRepository: HospitalRepository = HospitalRepository()

    fun getHospital(city: String, apiKey: String): LiveData<HospitalModel> {
        return hospitalRepository.getHospital(city, apiKey)
    }
}