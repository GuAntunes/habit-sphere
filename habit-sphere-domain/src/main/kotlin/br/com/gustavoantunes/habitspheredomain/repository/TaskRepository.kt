package br.com.gustavoantunes.habitspheredomain.repository

import br.com.gustavoantunes.habitspheredomain.model.Task
import java.util.*

interface TaskRepository {
    fun getAllTasks(): List<Task>
    fun getTaskById(taskId: UUID): Task?
    fun createTask(task: Task): Task
    fun updateTask(taskId: UUID, updatedTask: Task): Task
    fun deleteTask(taskId: UUID)
}