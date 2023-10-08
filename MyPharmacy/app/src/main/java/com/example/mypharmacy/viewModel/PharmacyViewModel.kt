package com.example.mypharmacy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mypharmacy.model.PharmacyModel
import com.example.mypharmacy.repository.PharmacyRepository

class PharmacyViewModel : ViewModel(){

    private val pharmacyRepository: PharmacyRepository = PharmacyRepository()

    fun getPharmacy(city: String, apiKey: String): LiveData<PharmacyModel> {
        return pharmacyRepository.getPharmacy(city, apiKey)
    }
}