package com.example.temperatureconverter

import org.junit.Test
import org.junit.Assert.*


class TempConverterModelTest {

    @Test
    fun testCelsiusToFahrenheit() {
        val converter = TempConverterModel()
        assertEquals(32, converter.celsiusToFahrenheit(0))
        assertEquals(50, converter.celsiusToFahrenheit(10))
        assertEquals(212, converter.celsiusToFahrenheit(100))
    }

    @Test
    fun testFahrenheitToCelsius() {
        val converter = TempConverterModel()
        assertEquals(0, converter.fahrenheitToCelsius(32))
        assertEquals(10, converter.fahrenheitToCelsius(50))
        assertEquals(100, converter.fahrenheitToCelsius(212))
    }

    @Test
    fun testCheckFarhen() {
        val converter = TempConverterModel()
        assertEquals("warmer", converter.chekfarhen(59))
        assertEquals("", converter.chekfarhen(80))
        assertEquals("colder", converter.chekfarhen(104))
    }

    @Test
    fun testCheckCel() {
        val converter = TempConverterModel()
        assertEquals("warmer", converter.checkcel(15))
        assertEquals("", converter.checkcel(20))
        assertEquals("colder", converter.checkcel(40))
    }


}