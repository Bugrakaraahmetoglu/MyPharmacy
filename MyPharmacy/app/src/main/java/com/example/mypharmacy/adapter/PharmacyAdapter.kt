package com.example.mypharmacy.adapter

import com.example.mypharmacy.databinding.ItemListBinding
import com.example.mypharmacy.model.Data


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypharmacy.R


class PharmacyAdapter(private val dataList: List<Data>) : RecyclerView.Adapter<PharmacyAdapter.PharmacyViewHolder>() {
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val itemListBinding: ItemListBinding = DataBindingUtil.inflate(
            layoutInflater!!,
            R.layout.item_list,
            parent,
            false
        )
        return PharmacyViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        holder.bindPharmacy(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class PharmacyViewHolder(private val itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {

        fun bindPharmacy(data: Data) {
            itemListBinding.pharmacy = data
            itemListBinding.executePendingBindings()
        }
    }
}