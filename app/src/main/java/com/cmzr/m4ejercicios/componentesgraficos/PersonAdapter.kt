package com.cmzr.m4ejercicios.componentesgraficos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
    val id = view.findViewById<TextView>(R.id.userId)
    val name = view.findViewById<TextView>(R.id.nameText)
    val textTweet = view.findViewById<TextView>(R.id.textoTweet)
    val avatarImage = view.findViewById<ImageView>(R.id.avatarImage)

    fun render(person: Person){
        id.text = person.id
        name.text = person.name
        textTweet.text = person.textoTweet
    }
}