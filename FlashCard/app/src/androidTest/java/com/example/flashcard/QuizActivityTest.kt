package com.example.flashcard


import android.widget.EditText
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class QuizActivityTest {

    private lateinit var scenario: ActivityScenario<QuizActivity>


    @Before
    fun setUp() {
        scenario = launch(QuizActivity::class.java)

    }

    @After
    fun tearDown() {
        scenario.close()

    }

    @Test
    fun useAppContextTest() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(
            "com.example.flashcard",
            appContext.getPackageName()
        )
    }




}


