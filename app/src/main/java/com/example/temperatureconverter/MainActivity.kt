package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
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
    private var snackbar: Snackbar? = null


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
                    if (temperatureConverter.checkcel(progress).equals("warmer")) {

                        val snackBarView = Snackbar.make(
                            window.decorView.rootView,
                            R.string.warmer,
                            Snackbar.LENGTH_SHORT
                        )
                        val view = snackBarView.view
                        val params = view.layoutParams as FrameLayout.LayoutParams
                        view.layoutParams = params
                        snackBarView.show()
                    } else {
                        snackbar?.dismiss()
                        snackbar = null
                    }
                    if (temperatureConverter.checkcel(progress).equals("colder")) {

                        val snackBarView = Snackbar.make(
                            window.decorView.rootView,
                            R.string.colder,
                            Snackbar.LENGTH_SHORT
                        )
                        val view = snackBarView.view
                        val params = view.layoutParams as FrameLayout.LayoutParams
                        view.layoutParams = params
                        snackBarView.show()
                    } else {
                        snackbar?.dismiss()
                        snackbar = null
                    }


                celsius = progress
                fahrenheit = temperatureConverter.celsiusToFahrenheit(progress)
                binding.fahrenheitSeekBar.progress = fahrenheit
                binding.celsiusValueBox.text = progress.toString()
            }
                else{
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
                    if (temperatureConverter.chekfarhen(progress).equals("warmer")) {

                        val snackBarView = Snackbar.make(
                            window.decorView.rootView,
                            R.string.warmer,
                            Snackbar.LENGTH_SHORT
                        )
                        val view = snackBarView.view
                        val params = view.layoutParams as FrameLayout.LayoutParams
                        view.layoutParams = params
                        snackBarView.show()
                    } else {
                        snackbar?.dismiss()
                        snackbar = null
                    }
                    if (temperatureConverter.chekfarhen(progress).equals("colder")) {

                        val snackBarView = Snackbar.make(
                            window.decorView.rootView,
                            R.string.colder,
                            Snackbar.LENGTH_SHORT
                        )
                        val view = snackBarView.view
                        val params = view.layoutParams as FrameLayout.LayoutParams
                        view.layoutParams = params
                        snackBarView.show()
                    } else {
                        snackbar?.dismiss()
                        snackbar = null
                    }

                    fahrenheit = progress
                    celsius = temperatureConverter.fahrenheitToCelsius(progress)
                    binding.celsiusSeekBar.progress = celsius
                    binding.fahrenheitValueBox.text = progress.toString()

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