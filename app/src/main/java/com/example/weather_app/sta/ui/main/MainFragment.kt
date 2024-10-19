package com.example.weather_app.sta.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.weather_app.R
import com.example.weather_app.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment:Fragment() {
    private lateinit var adapter: WeatherDetailsViewPagerAdapter
    private lateinit var viewPager: ViewPager2
    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: DataModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = WeatherDetailsViewPagerAdapter(this)
        viewPager = binding.weatherPager
        viewPager.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.searchedWeathers.collect{
                    adapter.weather_list = it
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sideEffect.collect {
                Toast.makeText(requireContext(), R.string.common_error,Toast.LENGTH_SHORT).show()
            }
        }
        initListeners()
    }
    private fun initListeners() {
        binding.apply {
            cityInput.setOnEditorActionListener { _, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    viewModel.onRequest(cityInput.text.toString())
                    true
                } else {
                    false
                }
            }
        }
    }
}
