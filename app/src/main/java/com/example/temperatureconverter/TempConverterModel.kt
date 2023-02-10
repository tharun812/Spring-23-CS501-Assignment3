package com.example.temperatureconverter

class TempConverterModel {



    fun celsiusToFahrenheit(celsius: Float): Float {
        return (celsius * 9/5) + 32
    }

    fun fahrenheitToCelsius(fahrenheit: Float): Float {
        return (fahrenheit - 32) * 5/9
    }
}