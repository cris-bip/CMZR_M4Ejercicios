package com.cmzr.m4ejercicios.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cmzr.m4ejercicios.R
import com.cmzr.m4ejercicios.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)

        binding.btNextFragment.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView, SecondFragment.newInstance())
                .addToBackStack("SecondFragment")
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}