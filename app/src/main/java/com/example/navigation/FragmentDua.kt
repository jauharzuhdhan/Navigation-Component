package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.navigation.databinding.FragmentDuaBinding

class FragmentDua : Fragment() {
    private var _binding: FragmentDuaBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDuaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aName = arguments?.getString(FragmentSatu.EXTRA_NAME)

        binding.tvNama.text = "Nama kamu: $aName"

        binding.btnToFragmentTiga.setOnClickListener{ view
            if (binding.etName.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom nama masih kosong", Toast.LENGTH_SHORT).show()
            } else{
                val actionToFragmentTiga =
                    FragmentDuaDirections.actionFragmentDuaToFragmentTiga()
                actionToFragmentTiga.name = binding.etName.text.toString()
                view.findNavController().navigate(actionToFragmentTiga)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}