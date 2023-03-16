package com.example.retrofitexample1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample1.adapter.TasksAdapter
import com.example.retrofitexample1.databinding.ActivityMainBinding
import com.example.retrofitexample1.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    // Elementos de la logica
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var tasksAdapter: TasksAdapter

    // Elementos de la UI
    private lateinit var rvTasks: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvTasks = binding.rvTasks
    }


    private fun initUI() {
        viewModel.tasks.observe(this, Observer {tasksList ->
            tasksAdapter = TasksAdapter(tasksList)
            rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            rvTasks.adapter = tasksAdapter
        })

    }
}
