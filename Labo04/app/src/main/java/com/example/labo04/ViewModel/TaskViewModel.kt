package com.example.labo04.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.labo04.Model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.collections.mutableListOf

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    val tasks = _tasks.asStateFlow()


    class GeneralViewModel: ViewModel() {
        private val _tasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
        val tasks = _tasks.asStateFlow()

        fun addTask(task: Task) {
            _tasks.value = _tasks.value.toMutableList().apply { add(task) }
        }
    }

}
