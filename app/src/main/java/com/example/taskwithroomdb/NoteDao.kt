package com.example.taskwithroomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)             // this conflict line is related to no conflict between similar id note if ever happen
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note_table ORDER BY id ASC")
     fun getAllNotes():LiveData<List<Note>>
}