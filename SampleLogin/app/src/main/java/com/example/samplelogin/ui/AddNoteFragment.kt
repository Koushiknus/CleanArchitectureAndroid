package com.example.samplelogin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.samplelogin.R
import com.example.samplelogin.databinding.FragmentAddNoteBinding
import com.example.samplelogin.db.Note
import com.example.samplelogin.db.NoteDatabase
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {

    private lateinit var binding: FragmentAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnSave.setOnClickListener {
            val noteTitle = binding.editTextTitle.text.toString().trim()
            val noteBody = binding.editTextNote.text.toString().trim()

            if(noteTitle.isEmpty()){
                binding.editTextTitle.error = "title required"
                binding.editTextTitle.requestFocus()
                return@setOnClickListener
            }

            if(noteBody.isEmpty()){
                binding.editTextNote.error = "title required"
                binding.editTextNote.requestFocus()
                return@setOnClickListener
            }
            launch {
                val note = Note(noteTitle,noteBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNote(note)
                    it.toast("Note Saved")
                    findNavController().navigate(R.id.action_addNoteFragment_to_noteHomeFragment)
                }
            }

        }
    }




}