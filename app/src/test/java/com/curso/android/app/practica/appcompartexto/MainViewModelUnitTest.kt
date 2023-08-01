package com.curso.android.app.practica.appcompartexto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.appcompartexto.model.TypeResponse
import com.curso.android.app.practica.appcompartexto.view.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel


    @Before
    fun setup(){
        viewModel = MainViewModel()
    }

    @Test
    fun testEmptyStrings() {
        val text1 = ""
        val text2 = ""
        viewModel.textsComparison(text1,text2,false) // Aquí puedes probar con true o false para compareUpperCase
        assertEquals(TypeResponse.EMPTY, viewModel.response.value?.equalText) // Asegúrate de tener una variable "response" que contenga la respuesta
    }

    @Test
    fun testEqualStrings_without_uppercase() {
        val text1 = "hola"
        val text2 = "hola"
        viewModel.textsComparison(text1, text2, false) // Aquí puedes probar con true o false para compareUpperCase
        assertEquals(TypeResponse.EQUAL, viewModel.response.value?.equalText) // Asegúrate de tener una variable "response" que contenga la respuesta
    }

    @Test
    fun testEqualStrings_with_uppercase() {
        val text1 = "HOla"
        val text2 = "HOla"
        viewModel.textsComparison(text1, text2, true) // Aquí puedes probar con true o false para compareUpperCase
        assertEquals(TypeResponse.EQUAL, viewModel.response.value?.equalText) // Asegúrate de tener una variable "response" que contenga la respuesta
    }

    @Test
    fun testDifferentStrings_without_uppercase() {
        val text1 = "hola"
        val text2 = "chau"
        viewModel.textsComparison(text1, text2, false) // Aquí puedes probar con true o false para compareUpperCase
        assertEquals(TypeResponse.DIFFERENT, viewModel.response.value?.equalText) // Asegúrate de tener una variable "response" que contenga la respuesta
    }

    @Test
    fun testDifferentStrings_with_uppercase() {
        val text1 = "hola"
        val text2 = "HOlA"
        viewModel.textsComparison(text1, text2, true) // Aquí puedes probar con true o false para compareUpperCase
        assertEquals(TypeResponse.DIFFERENT, viewModel.response.value?.equalText) // Asegúrate de tener una variable "response" que contenga la respuesta
    }
}