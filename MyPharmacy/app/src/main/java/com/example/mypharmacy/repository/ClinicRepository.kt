package com.example.mypharmacy.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypharmacy.model.ClinicModel
import com.example.mypharmacy.model.HospitalModel
import com.example.mypharmacy.service.ApiClient
import com.example.mypharmacy.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClinicRepository {

    private val apiService : ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun getClinics(city : String,apiKey:String) : LiveData<ClinicModel> {
        val data = MutableLiveData<ClinicModel>()
        apiService.getClinics(city, apiKey).enqueue(object : Callback<ClinicModel> {
            override fun onResponse(call: Call<ClinicModel>, response: Response<ClinicModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<ClinicModel>, t: Throwable) {

            }

        })

        return data
    }
}