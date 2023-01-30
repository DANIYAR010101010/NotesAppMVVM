package com.io.muhsin.notesappmvvm.utils

import com.io.muhsin.notesappmvvm.database.DataBaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DataBaseRepository

object Constants{
    object Keys{
        const val NOTE_DATABASE = "notes_database"
        const val TABLE_NAME = "notes_table"
        const val ADD_NEW_NOTE = "Add new note"
        const val NOTE_TITLE = "Note title"
        const val NOTE_SUBTITLE = "Note subtitle"
        const val ADD_NOTE = "Add note"
        const val ADD_ICONS = "Add Icons"
        const val TITLE = "Title"
        const val SUBTITLE = "Subtitle"
        const val WHAT_WILL_WE_USE = "what will we use?"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE = "FireBase"
        const val NOTES_APP = "Notes App"
        const val UNKNOWN_VM_CLASS = "Unknown ViewModel class"
        const val ID = "Id"
        const val NONE = "none"
        const val UPDATE = "UPDATE"
        const val DELETE = "DELETE"
        const val NAV_BACK = "NAV_BACK"
        const val EDIT_NOTE = "Edit note"
        const val EMPTY = ""
        const val UPDATE_NOTE = "Update note"

    }
    object Screens{
        const val START_SCREEN= "start_screen"
        const val MAIN_SCREEN= "main_screen"
        const val ADD_SCREEN= "add_screen"
        const val NOTE_SCREEN= "note_screen"

    }

}