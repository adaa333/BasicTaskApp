package com.example.taskapp

import android.app.Application
import androidx.room.Room
import com.example.taskapp.data.database.TaskDataBase

class TaskApp : Application() {

    companion object {
        lateinit var database: TaskDataBase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        // Inicializar la base de datos de Room
        database = Room.databaseBuilder(
            applicationContext,
            TaskDataBase::class.java, "database-name"
        ).build()

        // Otros códigos de inicialización aquí
    }
}