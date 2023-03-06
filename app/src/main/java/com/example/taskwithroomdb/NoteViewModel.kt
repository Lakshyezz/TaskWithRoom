package com.example.taskwithroomdb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    val allNotes: LiveData<List<Note>>
    val repository: NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).dao()
        repository = NoteRepository(dao)

        allNotes = repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }
    fun updateNode(note: Note) = viewModelScope.launch {
        repository.update(note)
    }
    fun insertNote(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }
}