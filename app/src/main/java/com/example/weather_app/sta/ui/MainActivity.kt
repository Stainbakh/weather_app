package com.example.weather_app.sta.ui
import android.os.Bundle

import androidx.fragment.app.FragmentActivity

import com.example.weather_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

            setContentView(binding.root)

        }

    }