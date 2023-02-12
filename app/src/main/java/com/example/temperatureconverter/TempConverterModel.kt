package com.example.temperatureconverter

import com.google.android.material.snackbar.Snackbar

class TempConverterModel {



    fun celsiusToFahrenheit(celsius: Int): Int {
        return (celsius * 9/5) + 32
    }

    fun fahrenheitToCelsius(fahrenheit: Int): Int {
        return (fahrenheit - 32) * 5/9
    }

    fun chekfarhen(prog: Int): String {
        if (prog <= 59) {
            return ("warmer")
        } else if (prog >= 104){
            return ("colder")
        }
        return ""
    }

    fun checkcel(prog: Int): String {
        if (prog <= 15) {
            return ("warmer")
        } else if (prog >= 40){
            return ("colder")
        }
        return ""
    }
}

/**
class TemperatureConverter {
    fun celsiusToFahrenheit(celsius: Int) = (celsius * 9 / 5) + 32
    fun fahrenheitToCelsius(fahrenheit: Int) = (fahrenheit - 32) * 5 / 9
}
        */

