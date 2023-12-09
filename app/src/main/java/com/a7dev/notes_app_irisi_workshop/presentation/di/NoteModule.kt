package com.a7dev.notes_app_irisi_workshop.presentation.di

import android.content.Context
import androidx.room.Room
import com.a7dev.notes_app_irisi_workshop.data.dao.NoteDao
import com.a7dev.notes_app_irisi_workshop.data.database.NoteDatabase
import com.a7dev.notes_app_irisi_workshop.data.repository.NoteRepositoryImpl
import com.a7dev.notes_app_irisi_workshop.domain.repository.NoteRepository
import com.a7dev.notes_app_irisi_workshop.domain.useCase.GetNotes
import com.a7dev.notes_app_irisi_workshop.domain.useCase.SaveNote
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
object NoteModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): NoteDatabase {
        return Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            "notes_database"
        ).build()
    }

    @Provides
    fun provideNoteDao(database: NoteDatabase) : NoteDao {
        return database.getNoteDao()
    }

    @Provides
    fun provideNoteRepository(noteDao: NoteDao) : NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }

    @Provides
    fun provideInsertNote(noteRepository: NoteRepository) : SaveNote {
        return SaveNote(noteRepository)
    }

    @Provides
    fun provideGetNote(noteRepository: NoteRepository) : GetNotes {
        return GetNotes(noteRepository)
    }

}