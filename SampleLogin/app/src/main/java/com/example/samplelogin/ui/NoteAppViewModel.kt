package com.example.samplelogin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplelogin.db.Note
import com.example.samplelogin.db.NoteAppRepository
import kotlinx.coroutines.launch

class NoteAppViewModel(private val noteAppRepository: NoteAppRepository) : ViewModel() {

    private val _getAllNotes = MutableLiveData<List<Note>>()
      val getAllNotes : LiveData<List<Note>>
          get() = _getAllNotes

    fun addNote(note: Note) = viewModelScope.launch {
        noteAppRepository.addNote(note)
    }

    fun getAllNotes() = viewModelScope.launch {
        _getAllNotes.value = noteAppRepository.getAllNote()
    }


}