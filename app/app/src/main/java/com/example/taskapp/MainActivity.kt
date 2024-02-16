package com.example.taskapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taskapp.data.database.TaskDataBase
import com.example.taskapp.data.subject.SubjectRepository
import com.example.taskapp.data.subject.SubjectViewModel
import com.example.taskapp.data.subject.SubjectViewModelFactory
import com.example.taskapp.data.task.TaskRepository
import com.example.taskapp.data.task.TaskViewModel
import com.example.taskapp.data.task.TaskViewModelFactory
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.ui.add_subject.AddSubjectFragment
import com.example.taskapp.ui.subjects.SubjectListFragment
import com.example.taskapp.ui.theme.ThemeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var subjectViewModel: SubjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_subject_list, R.id.navigation_save_subject, R.id.navigation_theme
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.navView.setupWithNavController(navController)

        bottomNavigationView = binding.navView

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_theme -> {
                    replaceFragment(ThemeFragment())
                    true
                }
                R.id.navigation_save_subject -> {
                    replaceFragment(AddSubjectFragment())
                    true
                }
                R.id.navigation_subject_list -> {
                    replaceFragment(SubjectListFragment())
                    true
                }
                else -> false
            }
        }

        // Inicialización de ViewModel
        val taskRepository = TaskRepository(TaskDataBase.getDatabase(applicationContext).taskDao())
        val subjectRepository = SubjectRepository(TaskDataBase.getDatabase(applicationContext).subjectDao())

        val taskViewModelFactory = TaskViewModelFactory(taskRepository)
        taskViewModel = ViewModelProvider(this, taskViewModelFactory).get(TaskViewModel::class.java)

        val subjectViewModelFactory = SubjectViewModelFactory(subjectRepository)
        subjectViewModel = ViewModelProvider(this, subjectViewModelFactory).get(SubjectViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main, fragment)
            .commit()
    }
}

