package com.example.horoscopeapp.presentation.listHoroscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.horoscopeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListHoroscopeFragment : Fragment() {

    private val viewModel by viewModels<ListHorocopeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_horoscope, container, false)
    }
}