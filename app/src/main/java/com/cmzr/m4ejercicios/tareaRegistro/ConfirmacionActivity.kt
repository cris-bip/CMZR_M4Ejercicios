package com.cmzr.m4ejercicios.tareaRegistro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.cmzr.m4ejercicios.R

class ConfirmacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmacion)

        val gender = intent.getStringExtra("EXTRA_GENDER")
        findViewById<TextView>(R.id.nameOutputText).text = intent.getStringExtra("EXTRA_NAME")
        findViewById<TextView>(R.id.emailOutputText).text = intent.getStringExtra("EXTRA_EMAIL")
        findViewById<TextView>(R.id.passwordOutputText).text = intent.getStringExtra("EXTRA_PASSWORD")
        findViewById<TextView>(R.id.genderOutputText).text = gender

        if(gender.equals("Mujer")){
            findViewById<TextView>(R.id.welcomeLabel).text = "Bienvenida \uD83D\uDC69"
            findViewById<TextView>(R.id.welcomeLabel).setBackgroundColor(Color.MAGENTA)
        }else{
            findViewById<TextView>(R.id.welcomeLabel).text = "Bienvenido \uD83E\uDDD4"
            findViewById<TextView>(R.id.welcomeLabel).setBackgroundColor(Color.BLUE)
        }

    }
}