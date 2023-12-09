package com.a7dev.notes_app_irisi_workshop.domain.useCase

import androidx.lifecycle.LiveData
import com.a7dev.notes_app_irisi_workshop.data.dto.Note
import com.a7dev.notes_app_irisi_workshop.domain.repository.NoteRepository
import javax.inject.Inject

class GetNotes @Inject constructor (private val noteRepository: NoteRepository) {
    suspend operator fun invoke() : LiveData<List<Note>> = noteRepository.getNotes()
}