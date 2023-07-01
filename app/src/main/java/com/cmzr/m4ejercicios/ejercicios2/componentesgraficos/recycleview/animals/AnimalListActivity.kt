package com.cmzr.m4ejercicios.ejercicios2.componentesgraficos.recycleview.animals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmzr.m4ejercicios.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val list = findViewById<RecyclerView>(R.id.animalList)

        val animalList = listOf(
            Animal("León", "Naranja"),
            Animal("Tiburón", "Blanco"),
            Animal("Jabalí", "Café"),
            Animal("Cocodrilo", "Albino"))

        val animalAdapter = AnimalAdapter(animalList)
        animalAdapter.onItemSelected = { animal ->
            Toast.makeText(this, "Animal seleccionado: ${animal.name}", Toast.LENGTH_SHORT).show()
        }

        list.adapter = animalAdapter

        //list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        list.layoutManager = LinearLayoutManager(this)


    }
}