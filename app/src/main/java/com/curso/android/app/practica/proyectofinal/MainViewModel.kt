package com.curso.android.app.practica.proyectofinal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {

    private val _comparador = MutableLiveData<Comparador>()
    val comparador: LiveData<Comparador> get() = _comparador

    init {
        _comparador.value = Comparador("", "")
    }

    fun compararTextos(text1: String, text2: String) {
        val resultado = if (text1 == text2) {
            "Los textos son iguales."
        } else {
            "Los textos son diferentes."
        }
        _comparador.value = Comparador(text1, text2)
    }
}

