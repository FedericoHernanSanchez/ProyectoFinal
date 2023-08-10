package com.curso.android.app.practica.proyectofinal

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var resultTextView: TextView
    private lateinit var texto1EditText: EditText
    private lateinit var texto2EditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparison)





        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        resultTextView = findViewById(R.id.resultTextView)
        texto1EditText = findViewById(R.id.editText)
        texto2EditText = findViewById(R.id.editText1)
        val compararButton = findViewById<Button>(R.id.compareButton)



        compararButton.setOnClickListener {
            val text1 = texto1EditText.text.toString()
            val text2 = texto2EditText.text.toString()

            if (text1.isEmpty() || text2.isEmpty()) {
                Toast.makeText(this, "Ingresar texto en ambos campos", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.compararTextos(text1, text2)
            }
        }

        viewModel.comparador.observe(this) { comparador ->
            if (comparador.texto1.isNotEmpty() && comparador.texto2.isNotEmpty()) {
                val resultado = if (comparador.texto1 == comparador.texto2) {
                    "Los textos son iguales."
                } else {
                    "Los textos son diferentes."
                }
                resultTextView.text = resultado
            } else {
                resultTextView.text = ""
            }
        }

        texto1EditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                resultTextView.text = ""
            }
        }

        texto2EditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                resultTextView.text = ""
            }
        }
    }


}








