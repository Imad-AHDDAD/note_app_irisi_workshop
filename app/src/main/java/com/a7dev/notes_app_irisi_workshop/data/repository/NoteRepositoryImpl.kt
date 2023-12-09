package com.a7dev.notes_app_irisi_workshop.data.repository

import androidx.lifecycle.LiveData
import com.a7dev.notes_app_irisi_workshop.data.dao.NoteDao
import com.a7dev.notes_app_irisi_workshop.data.dto.Note
import com.a7dev.notes_app_irisi_workshop.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor (private val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    override suspend fun getNotes(): LiveData<List<Note>> {
        return noteDao.getNotes()
    }
}