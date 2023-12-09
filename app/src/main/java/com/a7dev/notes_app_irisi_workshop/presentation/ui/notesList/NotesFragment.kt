package com.a7dev.notes_app_irisi_workshop.presentation.ui.notesList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.a7dev.notes_app_irisi_workshop.R
import com.a7dev.notes_app_irisi_workshop.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private val viewModel: NotesViewModel by activityViewModels()
    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(layoutInflater)
        viewModel.getAllNotes()
        viewModel.allNotes.observe(viewLifecycleOwner) { list ->
            if (list != null) {
                binding.list.text = list.toString()
            }
        }
        return binding.root
    }

}