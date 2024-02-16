package com.example.taskapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskapp.data.subject.Subject
import com.example.taskapp.data.subject.SubjectDao
import com.example.taskapp.data.task.Task
import com.example.taskapp.data.task.TaskDao


@Database(entities = [Task::class, Subject::class], version = 1, exportSchema = false)
abstract class TaskDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun subjectDao(): SubjectDao

    companion object{
        @Volatile//?
        private var INSTANCE: TaskDataBase? = null

        fun getDatabase(context: Context): TaskDataBase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){ //returning the same instance of the DB para optimizar
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDataBase::class.java,
                    "task_database"
                ).build()
                INSTANCE =instance
                return instance
            }
        }


    }


}
