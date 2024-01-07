package com.example.samplelogin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.samplelogin.R


class NoteHomeFragment : Fragment() {

    lateinit var binding: com.example.samplelogin.databinding.FragmentNoteHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = com.example.samplelogin.databinding.FragmentNoteHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.floatingActionButton.setOnClickListener{
             findNavController().navigate(R.id.action_noteHomeFragment_to_addNoteFragment)
        }

    }

}