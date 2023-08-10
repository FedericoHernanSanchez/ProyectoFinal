package com.curso.android.app.practica.proyectofinal

import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityUITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompararButtonTextosIguales() {
        onView(withId(R.id.editText)).perform(typeText("abc"))
        onView(withId(R.id.editText1)).perform(typeText("abc"))
        onView(withId(R.id.compareButton)).perform(click())

        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son iguales.")))
    }


    @Test
    fun testCompararButtonTextosDistintos() {
        onView(withId(R.id.editText)).perform(typeText("ab"))
        onView(withId(R.id.editText1)).perform(typeText("abc"))
        onView(withId(R.id.compareButton)).perform(click())

        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son diferentes.")))
    }
    @Test
    fun testEditTextFocusClearsTextView() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        scenario.onActivity { activity ->
            val editText1 = activity.findViewById<EditText>(R.id.editText)
            val editText2 = activity.findViewById<EditText>(R.id.editText1)
            val resultTextView = activity.findViewById<TextView>(R.id.resultTextView)

            editText1.requestFocus()
            assert(resultTextView.text.isEmpty())

            editText2.requestFocus()
            assert(resultTextView.text.isEmpty())
        }
    }




}
