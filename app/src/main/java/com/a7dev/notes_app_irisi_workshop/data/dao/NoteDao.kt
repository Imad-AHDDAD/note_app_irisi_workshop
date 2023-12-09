package com.a7dev.notes_app_irisi_workshop.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.a7dev.notes_app_irisi_workshop.data.dto.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes_table")
    suspend fun getNotes() : LiveData<List<Note>>
}