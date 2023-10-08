package com.example.mypharmacy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mypharmacy.model.ClinicModel
import com.example.mypharmacy.repository.ClinicRepository

class ClinicViewModel : ViewModel() {
    private val clinicRepository: ClinicRepository = ClinicRepository()

    fun getClinics(city: String, apiKey: String): LiveData<ClinicModel> {
        return clinicRepository.getClinics(city, apiKey)
    }
}