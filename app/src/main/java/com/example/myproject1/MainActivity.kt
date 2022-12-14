package com.example.myproject1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myproject1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {

            val countryName = binding.countryNameEditText.text.toString()

            lifecycleScope.launch {

                try {
                    val countries = restCountriesApi.getCountryByName(countryName)
                    val country = countries[0]

                    binding.countryNameTextView.text = country.name
                    binding.capitalTextView.text = country.capital
                    binding.areaTextView.text = numberFormat(country.area)
                    binding.populationTextView.text = numberFormat(country.population)
                    binding.languageTextView.text = country.languages.joinToString { it.name }

                    loadPng(binding.imageView, country.flag)

                    binding.resultLayout.visibility = View.VISIBLE
                    binding.statusLayout.visibility = View.INVISIBLE

                } catch (e: Exception) {
                    binding.ststusText.text = "Country not found. Try again!"
                    binding.ststusImageView.setImageResource(R.drawable.ic_baseline_error_outline_24)

                    binding.resultLayout.visibility = View.INVISIBLE
                    binding.statusLayout.visibility = View.VISIBLE
                }

            }
        }
    }
}