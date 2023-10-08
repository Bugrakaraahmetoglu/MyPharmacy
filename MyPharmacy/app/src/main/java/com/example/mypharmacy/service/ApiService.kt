package com.example.mypharmacy.service

import com.example.mypharmacy.model.ClinicModel
import com.example.mypharmacy.model.HospitalModel
import com.example.mypharmacy.model.PharmacyModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("pharmacyLink")
    fun getPharmacyLink(
        @Query("city") city: String,
        @Query("apikey") apiKey: String
    ): Call<PharmacyModel>


    @GET("hospital")
    fun getHospitals(
        @Query("city") city: String,
        @Header("Authorization") authorization: String
    ): Call<HospitalModel>


    @GET("clinic")
    fun getClinics(
        @Query("city") city: String,
        @Header("Authorization") authorization: String
    ): Call<ClinicModel>
}
