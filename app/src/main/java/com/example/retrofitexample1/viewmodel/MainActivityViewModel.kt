package com.example.retrofitexample1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample1.model.TaskModel
import com.example.retrofitexample1.network.TestApi
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()
    private val _tasks = MutableLiveData<List<TaskModel>>()

    val tasks: LiveData<List<TaskModel>> = _tasks

    init {
        getTodos()
    }

    private fun getTodos() {
        // Inicia una corrutina
        viewModelScope.launch {
            try {
                _tasks.value = TestApi.retrofitService.getData()
                _status.value = "titulo de la primera tarea: ${_tasks.value}"
            } catch (e: Exception) {
                _status.value = "Fallo: ${e.message}"
            }
        }
    }

}