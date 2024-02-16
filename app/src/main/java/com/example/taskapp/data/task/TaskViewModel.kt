package com.example.taskapp.data.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {
    val allTasks: LiveData<List<Task>> = repository.allTasks

    suspend fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    suspend fun update(task: Task) = viewModelScope.launch {
        repository.update(task)
    }

    suspend fun delete(task: Task) = viewModelScope.launch {
        repository.delete(task)
    }
}
