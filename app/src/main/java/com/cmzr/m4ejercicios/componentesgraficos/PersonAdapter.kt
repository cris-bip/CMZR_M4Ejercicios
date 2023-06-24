package com.cmzr.m4ejercicios.componentesgraficos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cmzr.m4ejercicios.R

class PersonAdapter(private var list:List<Person>) : RecyclerView.Adapter<PersonViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person,
            parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.render(list[position])
    }

}

class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val name = view.findViewById<TextView>(R.id.nameText)

    fun render(person: Person){
        name.text = person.name
    }
}