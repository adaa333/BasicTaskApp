package com.example.taskapp.data.subject

import androidx.lifecycle.LiveData

class SubjectRepository(private val subjectDao: SubjectDao) {
    val allSubjects: LiveData<List<Subject>> = subjectDao.getAllSubjects()

    suspend fun insert(subject: Subject) {
        subjectDao.insertSubject(subject)
    }

    suspend fun delete(subject: Subject){
        subjectDao.deleteSubject(subject)
    }
}
