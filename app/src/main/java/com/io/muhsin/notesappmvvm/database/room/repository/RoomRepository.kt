package com.io.muhsin.notesappmvvm.database.room.repository

import androidx.lifecycle.LiveData
import com.io.muhsin.notesappmvvm.database.DataBaseRepository
import com.io.muhsin.notesappmvvm.database.room.dao.NoteRoomDao
import com.io.muhsin.notesappmvvm.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao):DataBaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSucces: () -> Unit) {
        noteRoomDao.addNote(note= note)
    }

    override suspend fun update(note: Note, onSucces: () -> Unit) {
        noteRoomDao.updateNote(note = note)
    }

    override suspend fun delete(note: Note, onSucces: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
    }
}