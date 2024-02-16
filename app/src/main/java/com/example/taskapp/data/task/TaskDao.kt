package com.example.taskapp.data.task

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks WHERE moduleName = :moduleName")
    fun getTasksByModule(moduleName: String): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks WHERE task_id = :taskId")
    fun findTaskById(taskId: Long): Task

    @Query ("SELECT * FROM tasks")
    fun getAllTasks(): LiveData<List<Task>>
}
