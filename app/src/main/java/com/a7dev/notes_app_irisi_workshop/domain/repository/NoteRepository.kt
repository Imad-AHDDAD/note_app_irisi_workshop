package com.a7dev.notes_app_irisi_workshop.domain.repository

import androidx.lifecycle.LiveData
import com.a7dev.notes_app_irisi_workshop.data.dto.Note

interface NoteRepository {
    suspend fun insertNote(note: Note)
    suspend fun getNotes() : LiveData<List<Note>>
}