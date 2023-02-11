package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.example.temperatureconverter.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var temperatureConverter: TempConverterModel

    private var celsius: Int = 0
    private var fahrenheit: Int = 32

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        temperatureConverter = TempConverterModel()

        binding.celsiusSeekBar.max =  100
        binding.fahrenheitSeekBar.max = 212

        //new code check

        binding.celsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    celsius = progress
                    fahrenheit = temperatureConverter.celsiusToFahrenheit(progress)
                    binding.fahrenheitSeekBar.progress =  fahrenheit
                    binding.celsiusValueBox.text = progress.toString()

                } else{
                    celsius = progress
                    fahrenheit = temperatureConverter.celsiusToFahrenheit(progress)
                    binding.fahrenheitSeekBar.progress =  fahrenheit
                    binding.celsiusValueBox.text =  progress.toString()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.fahrenheitSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    if (progress < 32) {
                        binding.fahrenheitSeekBar.progress = 32
                        Toast.makeText(
                            this@MainActivity,
                            "The Fahrenheit SeekBar cannot remain below 32° F",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        fahrenheit = progress
                        celsius = temperatureConverter.fahrenheitToCelsius(progress)
                        binding.celsiusSeekBar.progress = celsius
                        binding.fahrenheitValueBox.text = progress.toString()
                    }
                } else {
                    fahrenheit = progress
                    celsius = temperatureConverter.fahrenheitToCelsius(progress)
                    binding.celsiusSeekBar.progress = celsius
                    binding.fahrenheitValueBox.text =  progress.toString()
                }


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}