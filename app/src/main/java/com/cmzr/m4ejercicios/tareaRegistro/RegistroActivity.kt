package com.cmzr.m4ejercicios.tareaRegistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.cmzr.m4ejercicios.R

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        var sendSubmit = true
        var genderLabel = getRadioSelectionLabel(R.id.manOption)

        val submitBtn = findViewById<Button>(R.id.submitButton)

        val name = findViewById<TextView>(R.id.nameText)
        val surname = findViewById<TextView>(R.id.surnameText)

        val email = findViewById<TextView>(R.id.emailText)
        val password = findViewById<TextView>(R.id.passwordText)

        val gender = findViewById<RadioGroup>(R.id.genderRadioGroup)
        gender.setOnCheckedChangeListener { group, checkedId ->
            genderLabel = getRadioSelectionLabel(checkedId)
        }

        submitBtn.setOnClickListener {
            sendSubmit = name.text.isNotEmpty() && surname.text.isNotEmpty()
                    && email.text.isNotEmpty() && password.text.isNotEmpty()

            if(sendSubmit){
                val confirmIntent = Intent (this, ConfirmacionActivity::class.java).apply {
                    putExtra("EXTRA_NAME", "${name.text} ${surname.text}")
                    putExtra("EXTRA_EMAIL", "${email.text}")
                    putExtra("EXTRA_PASSWORD", "${password.text}")
                    putExtra("EXTRA_GENDER", genderLabel)
                }

                startActivity(confirmIntent)
            }else{
                Toast.makeText(
                    this,
                    "Favor de completar los campos para continuar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun getRadioSelectionLabel(selectedRadioId: Int) : String{
        return when(selectedRadioId){
            R.id.manOption -> "Hombre"
            R.id.womanOption -> "Mujer"
            else -> ""
        }
    }
}