package br.com.gustavoantunes.habitsphereapplication.service

import br.com.gustavoantunes.habitspheredomain.model.Task
import br.com.gustavoantunes.habitspheredomain.repository.TaskRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getAllTasks(): List<Task> {
        return taskRepository.getAllTasks()
    }

    fun getTaskById(taskId: UUID): Task? {
        return taskRepository.getTaskById(taskId)
    }

    fun createTask(task: Task): Task {
        return taskRepository.createTask(task)
    }

    fun updateTask(taskId: UUID, updatedTask: Task): Task {
        return taskRepository.updateTask(taskId, updatedTask)
    }

    fun deleteTask(taskId: UUID) {
        taskRepository.deleteTask(taskId)
    }
}