package com.example.retrofitexample1.adapter

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample1.R
import com.example.retrofitexample1.model.TaskModel

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cvTodo = view.findViewById<CardView>(R.id.cv_todo)
    private val tvTitle = view.findViewById<TextView>(R.id.tv_task_title)

    fun render(task: TaskModel) {
        val cardColor = if(task.completed) {
            R.color.task_completed
        } else {
            R.color.task_incomplete
        }

        cvTodo.setCardBackgroundColor(ContextCompat.getColor(cvTodo.context, cardColor))
        tvTitle.text = task.title


    }

}