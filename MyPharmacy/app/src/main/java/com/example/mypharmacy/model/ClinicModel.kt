package com.example.mypharmacy.model

data class ClinicModel(
    val `data`: List<ClinicData>,
    val message: String,
    val rowCount: Int,
    val status: String
)