package com.cmzr.m4ejercicios.ejercicios2.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.ActivitySelectionComponentBinding

class SelectionComponentActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_component)

        // Realiza binding para obtener todos los componentes declarados en el layout
        binding = ActivitySelectionComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = arrayListOf<String>("México", "Argentina", "Estados Unidos", "Inglaterra",
            "Japón", "Venezuela", "Rusia", "Colombia", "Alemania", "Korea del Norte", "Korea del Sur")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.countrySpinnerSelector.adapter = countryAdapter

        binding.countrySpinnerSelector.onItemSelectedListener = object : OnItemSelectedListener {
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

        binding.radioGender.setOnCheckedChangeListener { group, checkedId ->
            showRadioSelection(checkedId)
        }

        binding.btEnviar.setOnClickListener {
            showToast(binding.activateNotificationsCheckBox.isChecked)

            showRadioSelection(binding.radioGender.checkedRadioButtonId)
        }

        binding.activateNotificationsCheckBox.setOnCheckedChangeListener { _, isChecked ->
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