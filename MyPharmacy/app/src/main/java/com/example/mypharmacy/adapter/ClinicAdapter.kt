package com.example.mypharmacy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypharmacy.R
import com.example.mypharmacy.databinding.ClinicItemListBinding
import com.example.mypharmacy.model.ClinicData


class ClinicAdapter(private val dataList: List<ClinicData>) : RecyclerView.Adapter<ClinicAdapter.ClinicViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val clinicItemListBinding: ClinicItemListBinding = DataBindingUtil.inflate(
            layoutInflater!!,
            R.layout.clinic_item_list,
            parent,
            false
        )
        return ClinicViewHolder(clinicItemListBinding)
    }

    override fun onBindViewHolder(holder: ClinicViewHolder, position: Int) {
        holder.bindPharmacy(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ClinicViewHolder(private val clinicItemListBinding: ClinicItemListBinding) :
        RecyclerView.ViewHolder(clinicItemListBinding.root) {

        fun bindPharmacy(data: ClinicData) {
            clinicItemListBinding.clinic = data
            clinicItemListBinding.executePendingBindings()
        }
    }
}