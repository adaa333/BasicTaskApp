package com.example.taskapp.data.subject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.taskapp.data.subject.Subject
import com.example.taskapp.data.database.SubjectWithTasks

@Dao
interface SubjectDao  {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSubject(subject: Subject)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    fun updateSubject(subject: Subject)

    @Delete
    fun removeSubject(subject: Subject)

    @Query ("SELECT * FROM Subjects WHERE subject_id= :id")
    fun findSubjectById(id: Int)

    @Query("SELECT * FROM Subjects ORDER BY subject_id ASC")
    fun findAllSubjects(): LiveData<List<Subject>>

    @Transaction //?
    @Query("SELECT * FROM Subjects WHERE subject_id = :subjectId")
    fun getSubjectWithTasks(subjectId: Long): LiveData<SubjectWithTasks>
}
