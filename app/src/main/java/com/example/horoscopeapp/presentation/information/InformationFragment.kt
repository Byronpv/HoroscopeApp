package com.example.horoscopeapp.presentation.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.horoscopeapp.R
import com.example.horoscopeapp.presentation.listHoroscope.ListHorocopeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationFragment : Fragment() {

    private val viewModel by viewModels<InformationViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

}