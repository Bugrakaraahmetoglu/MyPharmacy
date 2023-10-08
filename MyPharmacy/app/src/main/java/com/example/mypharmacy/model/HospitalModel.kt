package com.example.mypharmacy.model

data class HospitalModel(
    val `data`: List<HospitalData>,
    val message: String,
    val rowCount: Int,
    val status: String
)