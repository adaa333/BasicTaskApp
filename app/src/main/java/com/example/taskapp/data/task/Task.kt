package com.example.taskapp.data.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Task.kt
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="task_id")
    val taskId: Long = 0L,
    val moduleName: String,
    val taskName: String,
    val isCompleted: Boolean = false
)
