package com.aditya.notesapp.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.aditya.notesapp.data.NotesDataSource
import com.aditya.notesapp.model.Note



class NoteViewModel: ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
         noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note) {
        noteList.add(note)
    }
    fun getAllNotes():List<Note>{
        return  noteList
    }
    fun removeNote(note: Note) {
        noteList.remove(note)

    }

}