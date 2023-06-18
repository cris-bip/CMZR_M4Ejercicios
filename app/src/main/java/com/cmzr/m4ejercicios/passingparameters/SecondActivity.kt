package com.cmzr.m4ejercicios.passingparameters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.cmzr.m4ejercicios.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Obtiene valores de llaves
        val nombre = intent.getStringExtra("EXTRA_NAME")
        val apellidos = intent.getStringExtra("EXTRA_SURNAME")
        val edad = intent.getIntExtra("EXTRA_AGE", -1)
        val genero = intent.getCharExtra("EXTRA_GENDER", 'E')
        val altura = intent.getDoubleExtra("EXTRA_HEIGHT", 0.00)

        // Configura SecondActivity
        val tvName = findViewById<TextView>(R.id.textViewName)
        val tvSurname = findViewById<TextView>(R.id.textViewApellido)
        val tvAge = findViewById<TextView>(R.id.textViewEdad)
        val tvGender = findViewById<TextView>(R.id.textViewGenero)
        val tvHeight = findViewById<TextView>(R.id.textViewAltura)

        tvName.text = nombre
        tvSurname.text = apellidos
        tvAge.text =  edad.toString()
        tvGender.text = genero.toString()
        tvHeight.text = altura.toString()

        // Configura resultado al regresar con el botón
        val btBack = findViewById<Button>(R.id.btBack)
        btBack.setOnClickListener {
            val returnIntent = Intent().apply{
                putExtra("EXTRA_IS_OK", true)
                putExtra("EXTRA_NAME", nombre)
                putExtra("EXTRA_SURNAME", apellidos)
                putExtra("EXTRA_AGE", edad)
                putExtra("EXTRA_GENDER", genero)
                putExtra("EXTRA_HEIGHT", altura)
            }

            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}