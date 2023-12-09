package com.a7dev.notes_app_irisi_workshop.presentation.ui.insertNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a7dev.notes_app_irisi_workshop.data.dto.Note
import com.a7dev.notes_app_irisi_workshop.domain.useCase.SaveNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertNoteViewModel @Inject constructor (private val saveNote: SaveNote) : ViewModel() {

    fun insertNote(note: Note) {
        viewModelScope.launch {
            saveNote(note)
        }

    }

}