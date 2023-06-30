package com.cmzr.m4ejercicios.ejercicios1.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cmzr.m4ejercicios.R

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.e("CICLO_DE_VIDA", "onCreate")
    }

    override fun onStart(){
        super.onStart()
        Log.e("CICLO_DE_VIDA", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("CICLO_DE_VIDA", "onResume")
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause(){
        super.onPause()
        Log.e("CICLO_DE_VIDA", "onPause")
    }

    override fun onRestart(){
        super.onRestart()
        Log.e("CICLO_DE_VIDA", "onRestart")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.e("CICLO_DE_VIDA", "onDestroy")
    }
}