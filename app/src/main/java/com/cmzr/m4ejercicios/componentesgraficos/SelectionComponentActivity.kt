package com.cmzr.m4ejercicios.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import com.cmzr.m4ejercicios.R

class SelectionComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_component)

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val activateNotifications = findViewById<CheckBox>(R.id.activateNotificationsCheckBox)

        val countrySelector = findViewById<Spinner>(R.id.countrySpinnerSelector)
        val countries = arrayListOf<String>("México", "Argentina", "Estados Unidos", "Inglaterra",
            "Japón", "Venezuela", "Rusia", "Colombia", "Alemania", "Korea del Norte", "Korea del Sur")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        countrySelector.adapter = countryAdapter

        countrySelector.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = countries[position]

                Toast.makeText(this@SelectionComponentActivity,
                    "Selección del país: $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@SelectionComponentActivity,
                     "Favor de seleccionar un país", Toast.LENGTH_SHORT).show()
            }
        }



        val radioGender = findViewById<RadioGroup>(R.id.radioGender)

        radioGender.setOnCheckedChangeListener { group, checkedId ->
            showRadioSelection(checkedId)
        }

        btEnviar.setOnClickListener {
            showToast(activateNotifications.isChecked)

            showRadioSelection(radioGender.checkedRadioButtonId)
        }

        activateNotifications.setOnCheckedChangeListener { _, isChecked ->
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
                    "El usuario desea notificaciones", Toast.LENGTH_SHORT)
                .show()
        }else{
            Toast
                .makeText(this,
                    "El usuario rechaza las notificaciones", Toast.LENGTH_SHORT)
                .show()
        }
    }
}