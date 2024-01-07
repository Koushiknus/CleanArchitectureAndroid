package com.example.samplelogin.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    private var note : Note? = Note("Koushik","test")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
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
                context?.let {
                    val mNote = Note(noteTitle,noteBody)
                    if(note == null ){
                        NoteDatabase(it).getNoteDao().addNote(mNote)
                        it.toast("Note Saved")
                    }else{
                        mNote.id = note!!.id
                        NoteDatabase(it).getNoteDao().updateNote(mNote)
                        it.toast("Note Updated")
                    }
                    findNavController().navigate(R.id.action_addNoteFragment_to_noteHomeFragment)
                }
            }

        }
    }

    fun deleteNote(){
        //Test Code
        note?.id = 1

        AlertDialog.Builder(context).apply {
            setTitle("Are u Sure ?")
            setMessage("You cannot undo this operation")
            setPositiveButton("yes"){ _,_ ->
                launch {
                    NoteDatabase(context).getNoteDao().deleteNote(note!!)
                    findNavController().navigate(R.id.action_addNoteFragment_to_noteHomeFragment)
                }
            }
        }.create().show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete -> if(note!=null) deleteNote()else context?.toast("Cannot delete")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }


}