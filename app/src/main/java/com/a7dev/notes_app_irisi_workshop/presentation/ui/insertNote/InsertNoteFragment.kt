package com.a7dev.notes_app_irisi_workshop.presentation.ui.insertNote

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a7dev.notes_app_irisi_workshop.R
import com.a7dev.notes_app_irisi_workshop.data.dto.Note
import com.a7dev.notes_app_irisi_workshop.databinding.FragmentInsertNoteBinding

class InsertNoteFragment : Fragment() {

    private lateinit var viewModel: InsertNoteViewModel
    private lateinit var binding: FragmentInsertNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertNoteBinding.inflate(layoutInflater)
        binding.apply {
            saveBtn.setOnClickListener {
                val title = title.text.toString().trim()
                val description = desc.text.toString().trim()
                viewModel.insertNote(Note(null, title, description))
            }
        }
        return binding.root
    }

}