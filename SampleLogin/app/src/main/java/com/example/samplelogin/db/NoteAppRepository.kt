package com.example.samplelogin.db

class NoteAppRepository(
    private val dao:NoteDao
) {

    suspend fun addNote(note: Note) =  dao.addNote(note)
    suspend fun updateNote(note: Note) = dao.updateNote(note)
    suspend fun deleteNote(note: Note) = dao.deleteNote(note)

    suspend fun getAllNote() = dao.getAllNotes()
}