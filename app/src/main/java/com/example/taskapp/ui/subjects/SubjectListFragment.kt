package com.example.taskapp.ui.subjects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp.R

class SubjectListFragment : Fragment() {

    private lateinit var subjectViewModel: SubjectViewModel // Asegúrate de tener tu ViewModel configurado

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subject_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SubjectAdapter() // Implementa tu adaptador según tus necesidades
        recyclerViewSubjects.adapter = adapter
        recyclerViewSubjects.layoutManager = LinearLayoutManager(context)

        subjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java) // Asegúrate de que tu ViewModel esté configurado

        subjectViewModel.allSubjects.observe(viewLifecycleOwner, Observer { subjects ->
            subjects?.let {
                adapter.setSubjects(it)
            }
        })

        // Configura la lógica de clic en los elementos de la lista si es necesario
        // recyclerViewSubjects.setOnItemClickListener { subject ->
        //     // Lógica para manejar la selección de una asignatura
        // }
    }
}

