package com.example.taskapp.ui.subjects

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.data.database.TaskDataBase
import com.example.taskapp.data.subject.Subject
import com.example.taskapp.data.subject.SubjectRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  SubjectViewModel(application: Application) : AndroidViewModel(application){

    val readAllSubjects : LiveData<List<Subject>>
    private val repository: SubjectRepository

    init{ //?
        val subjectDao = TaskDataBase.getDatabase(application).subjectDao()
        repository= SubjectRepository(subjectDao)
        readAllSubjects= repository.allSubjects
    }

    fun addSubject(subject: Subject){
        repository.insert(subject)

    }
}