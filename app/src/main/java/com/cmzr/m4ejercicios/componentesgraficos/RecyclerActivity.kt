package com.cmzr.m4ejercicios.componentesgraficos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmzr.m4ejercicios.R

class RecyclerActivity : AppCompatActivity() {

    val textoPrueba = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean in metus efficitur, efficitur tortor a, dapibus erat. Fusce nec malesuada est."
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val rvPerson = findViewById<RecyclerView>(R.id.peopleList)
        val personAdapter = PersonAdapter(arrayListOf(
            Person("@IbaiLlanos", "Ibai", textoPrueba),
            Person("@samyriveratv", "rivers", textoPrueba),
            Person("@JuanSGuarnizo", "ElJuaniquilador \uD83D\uDD77️", textoPrueba),
            Person("@elmarianaa", "ElMariana \uD83E\uDD19\uD83C\uDFFB", textoPrueba),
            Person("@arigameplays", "Ari Gameplays \uD83E\uDD0D", textoPrueba)
        ))

        rvPerson.adapter = personAdapter
        rvPerson.layoutManager = LinearLayoutManager(this)
    }
}