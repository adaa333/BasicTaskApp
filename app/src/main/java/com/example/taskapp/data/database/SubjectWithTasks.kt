package com.example.taskapp.data.database

import androidx.room.Embedded
import androidx.room.Relation
import com.example.taskapp.data.subject.Subject
import com.example.taskapp.data.task.Task

data class SubjectWithTasks (
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subject_id",
        entityColumn = "task_id"
    )
    val tasks: List<Task> = emptyList()
)