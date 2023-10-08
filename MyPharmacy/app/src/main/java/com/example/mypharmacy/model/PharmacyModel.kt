package com.example.mypharmacy.model

data class PharmacyModel(
    val `data`: List<Data>,
    val message: String,
    val rowCount: Int,
    val status: String
)