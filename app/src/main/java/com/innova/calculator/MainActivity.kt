package com.innova.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.innova.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            val editTextList = listOf(etValueOne, etValueTwo)

            btnAdd.setOnClickListener {
                val (a, b) = editTextList.map { it.formatToNumber() }
                clearFields(editTextList)
                showResult(tvResult, a.plus(b))
            }

            btnSub.setOnClickListener {
                val (a, b) = editTextList.map { it.formatToNumber() }
                clearFields(listOf(etValueOne, etValueTwo))
                showResult(tvResult, a.minus(b))
            }
        }
    }

    private fun showResult(tvResult: TextView, result: Double) {
        tvResult.text = result.toString()
    }

    private fun clearFields(editTextList: List<EditText>) =
        editTextList.map { it.text.clear() }
}