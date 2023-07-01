package com.cmzr.m4ejercicios.ejercicios1.passingparameters

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.ejercicios2.componentesgraficos.recycleview.animals.Animal

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Agrega botón de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Obtiene valores de llaves
        val nombre = intent.getStringExtra("EXTRA_NAME")
        val apellidos = intent.getStringExtra("EXTRA_SURNAME")
        val edad = intent.getIntExtra("EXTRA_AGE", -1)
        val genero = intent.getCharExtra("EXTRA_GENDER", 'E')
        val altura = intent.getDoubleExtra("EXTRA_HEIGHT", 0.00)


        val animal = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("EXTRA_ANIMAL", Animal::class.java)
        }else{
            intent.getSerializableExtra("EXTRA_ANIMAL") as Animal
        }

        Toast.makeText(this, "Animal ${animal?.name}", Toast.LENGTH_SHORT).show()

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
            finish()  // Termina la Activity
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{  // home es el id por defecto para el botón del back
                val returnIntent = Intent().apply{
                    putExtra("EXTRA_IS_OK", true)
                }

                setResult(RESULT_OK, returnIntent)

                // Realiza pop del stack de vistas
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}