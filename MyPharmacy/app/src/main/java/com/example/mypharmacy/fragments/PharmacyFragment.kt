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
import com.example.mypharmacy.adapter.PharmacyAdapter
import com.example.mypharmacy.databinding.FragmentPharmacyBinding
import com.example.mypharmacy.model.Data
import com.example.mypharmacy.viewModel.PharmacyViewModel


class PharmacyFragment : Fragment() {

    private lateinit var pharmacyViewModel: PharmacyViewModel
    private lateinit var binding: FragmentPharmacyBinding
    private val dataList = ArrayList<Data>()
    private lateinit var pharmacyAdapter: PharmacyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var myEditText: EditText
    private var city: String = "burdur"
    private val turkishCharacters = "ğĞıİşŞüÜöÖçÇ"
    private lateinit var search : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPharmacyBinding.inflate(inflater, container, false)
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
        pharmacyViewModel = ViewModelProvider(this).get(PharmacyViewModel::class.java)
        pharmacyAdapter = PharmacyAdapter(dataList)
        binding.recView.adapter = pharmacyAdapter
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
    }

    private fun getPharmacy() {

        pharmacyViewModel.getPharmacy(
            city,
            "cpfe4LkdDnLMiq4A11YE5G913RT2wMjaeDSESv8MM3PD6J3Y1qb5jGlgQ1ch"
        )
            .observe(viewLifecycleOwner, { getPharmacyResponse ->

                if (getPharmacyResponse != null) {
                    if (getPharmacyResponse.data != null) {
                        dataList.addAll(getPharmacyResponse.data)
                        pharmacyAdapter.notifyDataSetChanged()
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
            getPharmacy()
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