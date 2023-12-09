package com.a7dev.notes_app_irisi_workshop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.a7dev.notes_app_irisi_workshop.data.dao.NoteDao
import com.a7dev.notes_app_irisi_workshop.data.dto.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
}