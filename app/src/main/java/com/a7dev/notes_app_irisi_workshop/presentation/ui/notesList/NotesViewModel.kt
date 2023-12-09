package com.a7dev.notes_app_irisi_workshop.presentation.ui.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a7dev.notes_app_irisi_workshop.data.dto.Note
import com.a7dev.notes_app_irisi_workshop.domain.useCase.GetNotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor (private val getNotes: GetNotes) : ViewModel() {
    lateinit var allNotes: LiveData<List<Note>>
    fun getAllNotes() {
        viewModelScope.launch {
            allNotes = getNotes()
        }
    }

}