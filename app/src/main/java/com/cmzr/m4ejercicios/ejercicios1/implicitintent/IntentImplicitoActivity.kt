package com.cmzr.m4ejercicios.ejercicios1.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.cmzr.m4ejercicios.R

class IntentImplicitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_implicito)

        val btUrl = findViewById<Button>(R.id.btUrl)

        btUrl.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"))
            startActivity(browserIntent)
        }
    }
}