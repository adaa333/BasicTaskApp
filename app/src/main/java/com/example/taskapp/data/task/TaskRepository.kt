package com.example.taskapp.data.task

import androidx.lifecycle.LiveData


class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    fun insert(task: Task) {
        taskDao.insertTask(task)
    }

    fun update(task: Task) {
        taskDao.updateTask(task)
    }

    fun delete(task: Task) {
        taskDao.deleteTask(task)
    }
}
