package com.curso.android.app.practica.proyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    class MainViewModelTest {

        @get:Rule
        val instantTaskExecutorRule = InstantTaskExecutorRule()

        private lateinit var viewModel: MainViewModel

        @Before
        fun setup() {
            viewModel = MainViewModel()
        }

        @Test
        fun `test compararTextos`() {
            viewModel.compararTextos("abc", "abc")
            val comparadorIguales = viewModel.comparador.value

            // Verificar si el Comparador contiene los valores esperados
            assertEquals("abc", comparadorIguales?.texto1)
            assertEquals("abc", comparadorIguales?.texto2)

            viewModel.compararTextos("abc", "def")
            val comparadorDiferentes = viewModel.comparador.value

            // Verificar si el Comparador contiene los valores esperados
            assertEquals("abc", comparadorDiferentes?.texto1)
            assertEquals("def", comparadorDiferentes?.texto2)
        }
    }
}
