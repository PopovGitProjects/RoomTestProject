package com.example.roomtestproject.fragments.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomtestproject.constants.Constants
import com.example.roomtestproject.db.NoteDataBase
import com.example.roomtestproject.db.repository.NoteRealization
import com.example.roomtestproject.models.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application

    fun initDB(){
        val dao = NoteDataBase.getInstance(context).getNoteDao()
        Constants.REPOSiTORY = NoteRealization(dao)
    }

    fun getAllNotes(): LiveData<List<NoteModel>>{
        return Constants.REPOSiTORY.allNotes
    }
}