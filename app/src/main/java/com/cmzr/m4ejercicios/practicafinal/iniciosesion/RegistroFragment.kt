package com.cmzr.m4ejercicios.practicafinal.iniciosesion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.FragmentRegistroBinding
import com.squareup.picasso.Picasso

class RegistroFragment : Fragment(R.layout.fragment_registro) {

    private  lateinit var binding: FragmentRegistroBinding

    private val registerImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT0ytxmkPbCzjiioabIX_yFrPKWSiEOynMhlQ&usqp=CAU"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegistroBinding.bind(view)

        Picasso.get().load(registerImageUrl).into(binding.ivRegister)

        binding.newUserRegistrationButton.setOnClickListener {

            if(allFieldsNotEmpty()){
                val homeIntent  = Intent(requireContext(), HomeActivity::class.java).apply {
                    putExtra("EXTRA_NAME", "${binding.nameEditText.text} ${binding.surnameEditText.text}")
                    putExtra("EXTRA_EMAIL", "${binding.registerEmailEditText.text}")
                    putExtra("EXTRA_PASSWORD", "${binding.registerPasswordEditText.text}")
                }

                startActivity(homeIntent)
            }else{
                Toast.makeText(
                    requireContext(),
                    "Favor de completar todo los campos del registro",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun allFieldsNotEmpty(): Boolean {
        return binding.nameEditText.text.isNotEmpty() && binding.surnameEditText.text.isNotEmpty()
                && binding.registerEmailEditText.text.isNotEmpty() && binding.registerPasswordEditText.text.isNotEmpty()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegistroFragment()
    }
}