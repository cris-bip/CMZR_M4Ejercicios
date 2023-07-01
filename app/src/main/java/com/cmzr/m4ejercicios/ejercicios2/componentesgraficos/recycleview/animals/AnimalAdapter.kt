package com.cmzr.m4ejercicios.ejercicios2.componentesgraficos.recycleview.animals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.cmzr.m4ejercicios.R
import com.squareup.picasso.Picasso

class AnimalAdapter(private val list:List<Animal>) : RecyclerView.Adapter<AnimalViewHolder>() {
    var onItemSelected : ((Animal) -> Unit)? = null

    // Se pueden renderizar diferentes tipos de vista utilizando el viewType
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }


}

class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val root = view.findViewById<ConstraintLayout>(R.id.root)

    val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
    val tvAnimal = view.findViewById<TextView>(R.id.tvAnimalName)



    fun render(animal: Animal, onItemSelected : ((Animal) -> Unit)?) {
        tvAnimal.text = animal.name

        root.setOnClickListener {
            onItemSelected?.invoke(animal)
        }

        Picasso.get()
            .load("https://www.nationalgeographic.com.es/medio/2022/12/12/leon-1_b21b27e1_221212155936_1280x720.jpg")
            .into(ivAnimal)
    }
}