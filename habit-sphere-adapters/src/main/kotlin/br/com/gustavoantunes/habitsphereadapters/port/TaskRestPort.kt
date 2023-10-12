package br.com.gustavoantunes.habitsphereadapters.port

import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.TaskCreateRequest
import br.com.gustavoantunes.habitspheredomain.model.Task
import java.util.UUID

interface TaskRestPort {
    fun getAllTasks(): List<Task>
    fun getTaskById(taskId: UUID): Task?
    fun createTask(task: TaskCreateRequest): Task
    fun updateTask(taskId: UUID, updatedTask: Task): Task
    fun deleteTask(taskId: UUID)
}