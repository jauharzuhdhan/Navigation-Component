package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigation.databinding.FragmentTigaBinding

class FragmentTiga : Fragment() {
    private var _binding: FragmentTigaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTigaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val aName: String = if(FragmentTigaArgs.fromBundle(arguments as Bundle).name.isNullOrEmpty()){
            FragmentTigaArgs.fromBundle(arguments as Bundle).name.toString()
        } else {
            val args : FragmentTigaArgs by navArgs()
            args.name.toString()
        }
        binding.tvName.text = "Namanya: $aName"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}