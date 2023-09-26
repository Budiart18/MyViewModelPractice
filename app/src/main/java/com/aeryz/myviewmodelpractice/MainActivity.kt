package com.aeryz.myviewmodelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aeryz.myviewmodelpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //TODO 1: Buat sebuah variable untuk menampung angka
    private var mCounter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO 2: Buat dua buah function untuk membandingkan penggunaan dengan dan tanpa viewModel
        withoutViewModel()
    }

    private fun withoutViewModel() {
        binding.btnPlus.setOnClickListener {
            mIncrementCount()
        }
        binding.btnMinus.setOnClickListener {
            mDecrementCount()
        }
    }

    private fun mIncrementCount() {
        mCounter += 1
        updateUI()
    }

    private fun mDecrementCount() {
        mCounter.let {
            if (it > 0) mCounter -= 1
        }
        updateUI()
    }

    private fun updateUI() {
        binding.tvCount.text = mCounter.toString()
    }
}