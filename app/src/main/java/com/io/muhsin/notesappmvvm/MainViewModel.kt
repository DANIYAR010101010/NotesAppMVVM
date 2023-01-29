package com.io.muhsin.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.io.muhsin.notesappmvvm.database.room.AppRoomDataBase
import com.io.muhsin.notesappmvvm.database.room.repository.RoomRepository
import com.io.muhsin.notesappmvvm.model.Note
import com.io.muhsin.notesappmvvm.utils.REPOSITORY
import com.io.muhsin.notesappmvvm.utils.TYPE_FIREBASE
import com.io.muhsin.notesappmvvm.utils.TYPE_ROOM
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
