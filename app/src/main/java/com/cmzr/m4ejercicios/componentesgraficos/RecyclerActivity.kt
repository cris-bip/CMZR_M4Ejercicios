package com.cmzr.m4ejercicios.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmzr.m4ejercicios.R

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPerson = findViewById<RecyclerView>(R.id.peopleList)
        val personAdapter = PersonAdapter(arrayListOf(
            Person("1", "Cristian"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael"),
            Person("1", "Michael")
        ))

        rvPerson.adapter = personAdapter
        rvPerson.layoutManager = LinearLayoutManager(this)
    }
}