package com.example.taskapp.ui.subjects


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.R
import com.example.taskapp.data.subject.Subject
import com.example.taskapp.databinding.FragmentSubjectListBinding

class SubjectAdapter() : RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {
    lateinit var binding: FragmentSubjectListBinding
    private var subjectList= emptyList<Subject>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subject_item, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = subjectList[position]
        holder.bind(subject)

        //aquí me quedé

    }

    override fun getItemCount(): Int {
        return subjectList.size
    }

    fun setData(subjects: List<Subject>){
        this.subjectList=subjects
        notifyDataSetChanged()
    }

    inner class SubjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val subjectNameTextView: TextView = itemView.findViewById(R.id.textViewSubjectName)

        fun bind(subject: Subject) {
            subjectNameTextView.text = subject.name
            // tema
        }
    }
}
