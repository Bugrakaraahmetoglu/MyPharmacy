package com.example.mypharmacy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypharmacy.R
import com.example.mypharmacy.adapter.HospitalAdapter
import com.example.mypharmacy.databinding.FragmentHospitalBinding
import com.example.mypharmacy.model.HospitalData
import com.example.mypharmacy.viewModel.HospitalViewModel


class HospitalFragment : Fragment() {

    private lateinit var hospitalViewModel: HospitalViewModel
    private lateinit var binding: FragmentHospitalBinding
    private val dataList = ArrayList<HospitalData>()
    private lateinit var hospitalAdapter: HospitalAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var myEditText: EditText
    private var city: String = "burdur"
    private val turkishCharacters = "ğĞıİşŞüÜöÖçÇ"
    private lateinit var search : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rec_view)
        search = view.findViewById(R.id.search)
        myEditText = view.findViewById(R.id.edit_text)
        clicked()
        doInitialization()
    }


    private fun doInitialization() {
        binding.recView.setHasFixedSize(true)
        hospitalViewModel = ViewModelProvider(this).get(HospitalViewModel::class.java)
        hospitalAdapter = HospitalAdapter(dataList)
        binding.recView.adapter = hospitalAdapter
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
    }

    private fun getHospitals() {

        hospitalViewModel.getHospital(
            city,
            "cpfe4LkdDnLMiq4A11YE5G913RT2wMjaeDSESv8MM3PD6J3Y1qb5jGlgQ1ch"
        )
            .observe(viewLifecycleOwner, { getHospitalResponse ->

                if (getHospitalResponse != null) {
                    if (getHospitalResponse.data != null) {
                        dataList.addAll(getHospitalResponse.data)
                        hospitalAdapter.notifyDataSetChanged()
                    }
                } else {
                    Toast.makeText(requireContext(), "null değil", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun clicked() {
        search.setOnClickListener {
            city = myEditText.text.toString()
            System.out.println(city)
            dataList.clear()
            getHospitals()
            if (isTurkishCharacter(myEditText.text.toString())) {
                Toast.makeText(requireContext(), "Türkçe karakter içeriyor!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isTurkishCharacter(inputText: String): Boolean {
        for (char in inputText) {
            if (turkishCharacters.contains(char)) {
                return true
            }
        }
        return false
    }

}