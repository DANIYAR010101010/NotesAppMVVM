package com.io.muhsin.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.io.muhsin.notesappmvvm.database.room.AppRoomDataBase
import com.io.muhsin.notesappmvvm.database.room.repository.RoomRepository
import com.io.muhsin.notesappmvvm.model.Note
import com.io.muhsin.notesappmvvm.utils.REPOSITORY
import com.io.muhsin.notesappmvvm.utils.TYPE_FIREBASE
import com.io.muhsin.notesappmvvm.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDataBase(type:String,onSucces:() -> Unit){
        Log.e("checkData","MainViewModel initDataBase with type :$type")
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDataBase.getInstance(context= context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSucces()
            }
        }
    }
    fun addNote(note: Note,onSucces: () -> Unit){
      viewModelScope.launch(Dispatchers.IO){
          REPOSITORY.create(note = note){
              viewModelScope.launch(Dispatchers.Main){
                  onSucces()
              }
          }
      }

    }
    fun readAllNotes() = REPOSITORY.readAll
}

class MainViewModelFactory(private val application: Application):
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T

        }
        throw  IllegalArgumentException("Unknown ViewModel class")
    }
}
