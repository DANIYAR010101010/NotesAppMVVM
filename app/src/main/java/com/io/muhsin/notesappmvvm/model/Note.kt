package com.io.muhsin.notesappmvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.io.muhsin.notesappmvvm.utils.Constants.Keys.TABLE_NAME
import java.io.Serializable

@Entity(tableName = TABLE_NAME)
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val subtitle: String,
) : Serializable
