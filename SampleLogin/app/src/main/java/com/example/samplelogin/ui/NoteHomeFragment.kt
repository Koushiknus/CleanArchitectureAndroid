package com.example.samplelogin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.samplelogin.R
import com.example.samplelogin.db.NoteDatabase
import kotlinx.coroutines.launch


class NoteHomeFragment : BaseFragment() {

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

        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        launch {
                context?.let {
                    val notes = NoteDatabase(it).getNoteDao().getAllNotes()
                    binding.recyclerview.adapter = NotesAdapter(notes)
                }
        }
        binding.floatingActionButton.setOnClickListener{
             findNavController().navigate(R.id.action_noteHomeFragment_to_addNoteFragment)
        }



    }

}