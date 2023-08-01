package com.curso.android.app.practica.appcompartexto.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.appcompartexto.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun compareEquals_without_Uppercase(){
        writeText(R.id.editText1,"hola")
        writeText(R.id.editText2, "hola")
        clickCompare()
        checkResponse("Los dos textos son iguales")
    }
    @Test
    fun compareEquals_with_Uppercase(){
        writeText(R.id.editText1,"HolA")
        writeText(R.id.editText2, "HolA")
        clickUppercase()
        clickCompare()
        checkResponse("Los dos textos son iguales")
    }

    @Test
    fun compareDifferent_without_Uppercase(){
        writeText(R.id.editText1,"holas")
        writeText(R.id.editText2, "holsa")
        clickCompare()
        checkResponse("Los dos textos son distintos")
    }
    @Test
    fun compareDifferent_with_Uppercase(){
        writeText(R.id.editText1,"hola")
        writeText(R.id.editText2, "hOlA")
        clickUppercase()
        clickCompare()
        checkResponse("Los dos textos son distintos")
    }

    @Test
    fun checkDeleteText(){
        writeText(R.id.editText1, "Hola que tal?")
        writeText(R.id.editText2, "Mi nombre es")
        clickDelete()
        checkEditTextEmpty()

    }

    private fun checkEditTextEmpty(){
        Espresso.onView(
            ViewMatchers.withId(R.id.editText1)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("")
            )
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.editText2)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("")
            )
        )
    }


    private fun checkResponse(expectedResponse: String) {
        Espresso.onView(
            ViewMatchers.withId(R.id.response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(expectedResponse)
            )
        )
    }

    private fun clickUppercase(){
        Espresso.onView(
            ViewMatchers.withId(R.id.checkBox)
        ).perform(
            ViewActions.click()
        )
    }

    private fun writeText(id: Int, text: String) {
        Espresso.onView(
            ViewMatchers.withId(id)
        ).perform(
            ViewActions.replaceText(text)
        )
    }

    private fun clickCompare() {
        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompare)
        ).perform(
            ViewActions.click()
        )
    }

    private fun clickDelete(){
        Espresso.onView(
            ViewMatchers.withId(R.id.btnBorrar)
        ).perform(
            ViewActions.click()
        )
    }
}