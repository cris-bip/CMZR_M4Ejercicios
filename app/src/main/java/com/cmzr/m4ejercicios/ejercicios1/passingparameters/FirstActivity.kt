package com.cmzr.m4ejercicios.ejercicios1.passingparameters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.ejercicios2.componentesgraficos.recycleview.animals.Animal

class FirstActivity : AppCompatActivity() {
    private val register = registerForActivityResult(StartActivityForResult()){result ->
        if(result.resultCode == RESULT_OK){
            val nombre = result.data?.getStringExtra("EXTRA_NAME")
            val apellido = result.data?.getStringExtra("EXTRA_SURNAME")
            val edad = result.data?.getIntExtra("EXTRA_AGE", -1)
            val genero = result.data?.getCharExtra("EXTRA_GENDER", 'E')
            val altura = result.data?.getDoubleExtra("EXTRA_HEIGHT", 0.00)

            val toastMsg = java.lang.StringBuilder()
                .append("resultCode=${result.resultCode}\n")
                .append("EXTRA_IS_OK=${result.data?.getBooleanExtra("EXTRA_IS_OK", false)} \n")
                .append("Mi nombre es: ${nombre} ${apellido}, edad: ${edad}\n")
                .append("género: ${genero}, altura: ${altura}")

            Toast.makeText(this,
                toastMsg.toString(),
                Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "resultCode=${result.resultCode} - CANCELLED", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val btCall = findViewById<Button>(R.id.btCall)

        val animal = Animal("Cocodrilo", "Albino")
        btCall.setOnClickListener {
            val secondIntent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Cristian Michael")
                putExtra("EXTRA_SURNAME", "Zuñiga Ruiz")
                putExtra("EXTRA_AGE", 29)
                putExtra("EXTRA_GENDER", 'M')
                putExtra("EXTRA_HEIGHT", 1.76)
                putExtra("EXTRA_ANIMAL", animal)
            }

            //startActivity(secondIntent) -
            register.launch(secondIntent)
        }
    }
}