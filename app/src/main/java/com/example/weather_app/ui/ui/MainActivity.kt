package com.example.weather_app.ui.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(binding.root)
        }
    }