package com.example.samplelogin.ui

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.samplelogin.db.Note
import com.example.samplelogin.db.NoteAppRepository
import com.example.samplelogin.db.NoteDatabase
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteAppViewModelTest : TestCase(){

    private lateinit var viewModel: NoteAppViewModel

    // Execute everthing synchronous

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()
        // Create ViewModel , Repository , DAO
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context,NoteDatabase::class.java).allowMainThreadQueries().build()
        val repository  = NoteAppRepository(db.getNoteDao())
        viewModel = NoteAppViewModel((repository))

    }

    @Test
    fun testNoteViewModel(){
        viewModel.addNote(Note("Jaya","test"))
        viewModel.getAllNotes()
        val result = viewModel.allNotes.getOrAwaitValue().find {
            it.title == "Jaya" && it.note == "test"
        }
        assertTrue(result != null)
    }

}