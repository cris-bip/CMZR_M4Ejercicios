package com.cmzr.m4ejercicios.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.FragmentReceiveParamsBinding
import com.cmzr.m4ejercicios.ejercicios2.componentesgraficos.recycleview.animals.Animal


class ReceiveParamsFragment : Fragment(R.layout.fragment_receive_params) {

    private lateinit var binding : FragmentReceiveParamsBinding

    private var name: String? = ""
    private var animal: Animal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("ARG_NAME")
            animal = it.getSerializable("ARG_ANIMAL") as Animal
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReceiveParamsBinding.bind(view)

        binding.tvName.text = name
        binding.tvAnimalName.text = animal?.name
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, animal: Animal) =
            ReceiveParamsFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_NAME", name)
                    putSerializable("ARG_ANIMAL", animal)
                }
            }
    }
}