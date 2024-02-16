package com.example.taskapp.data.subject

import androidx.lifecycle.LiveData

class SubjectRepository(private val subjectDao: SubjectDao) {
    val allSubjects: LiveData<List<Subject>> = subjectDao.findAllSubjects()

    fun insert(subject: Subject) {
        subjectDao.addSubject(subject)
    }

    fun delete(subject: Subject){
        subjectDao.removeSubject(subject)
    }
}
