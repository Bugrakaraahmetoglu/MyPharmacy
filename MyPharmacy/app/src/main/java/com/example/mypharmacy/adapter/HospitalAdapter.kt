package com.example.mypharmacy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypharmacy.R
import com.example.mypharmacy.databinding.HospitalItemListBinding
import com.example.mypharmacy.model.HospitalData

class HospitalAdapter(private val dataList: List<HospitalData>) : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val hospitalItemListBinding: HospitalItemListBinding = DataBindingUtil.inflate(
            layoutInflater!!,
            R.layout.hospital_item_list,
            parent,
            false
        )
        return HospitalViewHolder(hospitalItemListBinding)
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
        holder.bindPharmacy(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class HospitalViewHolder(private val hospitalItemListBinding: HospitalItemListBinding) :
        RecyclerView.ViewHolder(hospitalItemListBinding.root) {

        fun bindPharmacy(data: HospitalData) {
            hospitalItemListBinding.hospital = data
            hospitalItemListBinding.executePendingBindings()
        }
    }
}