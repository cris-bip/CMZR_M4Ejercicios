package com.cmzr.m4ejercicios.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.FragmentSendParamsBinding
import com.cmzr.m4ejercicios.ejercicios2.componentesgraficos.recycleview.animals.Animal

class SendParamsFragment : Fragment(R.layout.fragment_send_params) {

    private lateinit var binding : FragmentSendParamsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSendParamsBinding.bind(view)

        binding.btSend.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,
                    ReceiveParamsFragment
                        .newInstance("Cristian", Animal("León", "Amarillo")))
                .addToBackStack("ReceiveParamsFragment")
                .commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = SendParamsFragment()
    }
}