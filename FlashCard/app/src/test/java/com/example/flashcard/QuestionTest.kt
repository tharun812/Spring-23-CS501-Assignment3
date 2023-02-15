package com.example.flashcard

import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class QuestionTest {

    @Test
    fun calcOutput() {
        val inp1 = 23
        val inp2 = 3
        val operator = "+"
        val result = Question(inp1,inp2,operator).calcOutput()
        assertEquals(result,26)
    }
}