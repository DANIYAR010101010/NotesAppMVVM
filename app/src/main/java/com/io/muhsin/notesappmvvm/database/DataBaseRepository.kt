package com.io.muhsin.notesappmvvm.database

import androidx.lifecycle.LiveData
import com.io.muhsin.notesappmvvm.model.Note
import java.util.concurrent.TimeUnit

interface DataBaseRepository {
    val readAll : LiveData<List<Note>>

    suspend fun create(note: Note,onSucces :() ->  Unit)

    suspend fun update(note: Note,onSucces :() ->  Unit)

    suspend fun delete(note: Note,onSucces :() ->  Unit)
}