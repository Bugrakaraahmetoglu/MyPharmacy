package com.example.mypharmacy.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypharmacy.model.PharmacyModel
import com.example.mypharmacy.service.ApiClient
import com.example.mypharmacy.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PharmacyRepository {

    private val apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun getPharmacy(city: String, apiKey: String): LiveData<PharmacyModel> {
        val data = MutableLiveData<PharmacyModel>()
        apiService.getPharmacyLink(city, apiKey).enqueue(object : Callback<PharmacyModel> {
            override fun onResponse(call: Call<PharmacyModel>, response: Response<PharmacyModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<PharmacyModel>, t: Throwable) {

            }
        })

        return data
    }
}