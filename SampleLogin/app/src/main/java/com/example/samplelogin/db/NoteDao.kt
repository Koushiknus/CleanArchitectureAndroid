package com.example.samplelogin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    fun addNote(note: Note)

    @Query("Select * from note")
    fun getAllNotes() : List<Note>

    @Insert
    fun addMultipleNotes(vararg note: Note)
}