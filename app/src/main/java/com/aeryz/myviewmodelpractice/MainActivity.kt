package com.aeryz.myviewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.aeryz.myviewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 2: Buat function baru untuk implement viewModel
        withViewModel()
    }

    private fun withViewModel() {
        binding.btnPlus.setOnClickListener {
            wIncrementCount()
        }
        binding.btnMinus.setOnClickListener {
            wDecrementCount()
        }
        viewModel.vCounter.observe(this){result ->
            binding.tvCount.text = result.toString()
        }
    }

    private fun wDecrementCount() {
        viewModel.decrementCount()
    }

    private fun wIncrementCount() {
        viewModel.incrementCount()
    }

}