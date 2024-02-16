package com.example.taskapp.data.subject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Subject.kt
@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="subject_id")
    val subjectId: Long = 0L,
    val subjectName: String
)
