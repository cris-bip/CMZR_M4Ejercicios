package com.cmzr.m4ejercicios.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import com.cmzr.m4ejercicios.R

class SelectionComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_component)

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val hasCreditCard = findViewById<CheckBox>(R.id.hasTarjetaCredito)

        val radioGender = findViewById<RadioGroup>(R.id.radioGender)

        radioGender.setOnCheckedChangeListener { group, checkedId ->
            showRadioSelection(checkedId)
        }

        btEnviar.setOnClickListener {
            showToast(hasCreditCard.isChecked)

            showRadioSelection(radioGender.checkedRadioButtonId)
        }

        hasCreditCard.setOnCheckedChangeListener { _, isChecked ->
            showToast(isChecked)
        }
    }

    private fun showRadioSelection(selectedRadioId: Int){
        val radioValueSelected = when(selectedRadioId){
            R.id.radioMen -> "Hombre"
            R.id.radioWoman -> "Mujer"
            else -> ""
        }
        Toast.makeText(this, "El usuario es: $radioValueSelected", Toast.LENGTH_SHORT).show()
    }

    private fun showToast(isChecked: Boolean){
        if(isChecked){
            Toast
                .makeText(this,
                    "El usuario tiene tarjeta de crédito", Toast.LENGTH_SHORT)
                .show()
        }else{
            Toast
                .makeText(this,
                    "El usuario no tiene tarjeta de crédito", Toast.LENGTH_SHORT)
                .show()
        }
    }
}