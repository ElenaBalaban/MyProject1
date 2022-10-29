package com.example.myproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myproject1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcSumBatton.setOnClickListener {
            val number1 = binding.number1EeditText.text.toString().toInt()
            val number2 = binding.number2EeditText.text.toString().toInt()

            val sum = number1 + number2

            binding.ResultTextView.text = sum.toString()
        }

    }
}