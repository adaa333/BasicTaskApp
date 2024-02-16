package com.example.taskapp.data.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SubjectViewModel(private val repository: SubjectRepository) : ViewModel() {
    val allSubjects: LiveData<List<Subject>> = repository.allSubjects

    fun insert(subject: Subject) = viewModelScope.launch {
        repository.insert(subject)
    }

    fun delete(subject: Subject) = viewModelScope.launch {
        repository.delete(subject)
    }
}