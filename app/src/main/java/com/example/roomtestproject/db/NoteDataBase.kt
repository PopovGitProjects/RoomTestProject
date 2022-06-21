package com.example.roomtestproject.db

import android.content.Context
import android.provider.DocumentsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomtestproject.db.dao.NoteDao
import com.example.roomtestproject.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object{
        private var database: NoteDataBase ?= null

        @Synchronized
        fun getInstance(context: Context): NoteDataBase{
            return if (database == null){
                database = Room.databaseBuilder(context, NoteDataBase::class.java, "db")
                    .build()
                database as NoteDataBase
            }else{
                database as NoteDataBase
            }
        }
    }
}