package com.example.mypharmacy.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypharmacy.model.HospitalModel
import com.example.mypharmacy.service.ApiClient
import com.example.mypharmacy.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalRepository {

    private val apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun getHospital(city: String, apiKey: String): LiveData<HospitalModel> {
        val data = MutableLiveData<HospitalModel>()
        apiService.getHospitals(city, apiKey).enqueue(object : Callback<HospitalModel> {
            override fun onResponse(call: Call<HospitalModel>, response: Response<HospitalModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<HospitalModel>, t: Throwable) {

            }
        })

        return data
    }
}