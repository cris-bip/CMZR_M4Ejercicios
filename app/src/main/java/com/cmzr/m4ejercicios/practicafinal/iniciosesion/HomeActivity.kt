package com.cmzr.m4ejercicios.practicafinal.iniciosesion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameOutputText.text = intent.getStringExtra("EXTRA_NAME")
        binding.emailOutputText.text = intent.getStringExtra("EXTRA_EMAIL")
        binding.passwordOutputText.text = intent.getStringExtra("EXTRA_PASSWORD")
    }
}