package com.cmzr.m4ejercicios.practicafinal.iniciosesion

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.FragmentLoginBinding
import com.squareup.picasso.Picasso


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    private val emailTestingUser = "usuario.prueba@testing.team"
    private val passwordTestingUser = "cmzr.team"

    private val loginImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF5LVi2Z3km5IKdVtSjurgjf_hcbyyxKDyuNs8_e2DTAJcvlrSpiECQ7Z-AroobjKTFxE&usqp=CAU"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        Picasso.get().load(loginImageUrl).into(binding.ivLogin)

        binding.loginButton.setOnClickListener {
            val email = "${binding.emailEditText.text}"
            val password = "${binding.passwordEditText.text}"
            if(email.isNotEmpty() && password.isNotEmpty()){
                if(isValidTestingUser(email, password)){
                    val homeIntent  = Intent(requireContext(), HomeActivity::class.java).apply {
                        putExtra("EXTRA_NAME", getUserNameWithCredentials(email, password))
                        putExtra("EXTRA_EMAIL", "${binding.emailEditText.text}")
                        putExtra("EXTRA_PASSWORD", "${binding.passwordEditText.text}")
                    }

                    startActivity(homeIntent)
                }else{
                    // Usuario no registrado
                    showToastWithMessage("Credenciales incorrectas, favor de verificar o registrarse")
                }
            }else{
                showToastWithMessage("Favor de completar los campos o registrarse")
            }
        }

        binding.registerButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack("RegistroFragment")
                .replace(R.id.loginFragmentContainer, RegistroFragment.newInstance())
                .commit()
        }

    }

    private fun showToastWithMessage(message: String){
        Toast.makeText(
            requireContext(),
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun getUserNameWithCredentials(email: String, password: String): String {
        // Consultar usuarios registrados utilizando las credenciales.
        return "Usuario de prueba CMZR team"
    }

    private fun isValidTestingUser(email: String, password: String): Boolean{
        return email == emailTestingUser && password == passwordTestingUser
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}