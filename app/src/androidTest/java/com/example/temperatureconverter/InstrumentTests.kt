package com.example.temperatureconverter


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentTests {
    private lateinit var tempConverter: TempConverterModel

    @Before
    fun setUp() {
        tempConverter = TempConverterModel()
    }

    @Test
    fun testCelsiusToFahrenheit() {
        val result = tempConverter.celsiusToFahrenheit(0)
        assertEquals(32, result)
    }

    @Test
    fun testFahrenheitToCelsius() {
        val result = tempConverter.fahrenheitToCelsius(32)
        assertEquals(0, result)
    }

    @Test
    fun testChekFarhen() {
        val result = tempConverter.chekfarhen(0)
        assertEquals("warmer", result)
    }

    @Test
    fun testCheckCel() {
        val result = tempConverter.checkcel(0)
        assertEquals("warmer", result)
    }
}
