package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.repository

import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateId
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.entity.taskEntityOf
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.repository.jpa.TaskJpaRepository
import br.com.gustavoantunes.habitspheredomain.model.Task
import br.com.gustavoantunes.habitspheredomain.repository.TaskRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class TaskRepositoryImpl(
    private val taskJpaRepository: TaskJpaRepository
) : TaskRepository {
    override fun getAllTasks(): List<Task> {
        return taskJpaRepository.findAll().map { it.toTask() }
    }

    override fun getTaskById(taskId: UUID): Task? {
        return taskJpaRepository.findById(AggregateId(taskId)).orElse(null)?.toTask()
    }

    override fun createTask(task: Task): Task {
        return taskJpaRepository.insert(taskEntityOf(task)).toTask()
    }

    override fun updateTask(taskId: UUID, updatedTask: Task): Task {
        TODO("Not yet implemented")
    }

    override fun deleteTask(taskId: UUID) {
        taskJpaRepository.deleteById(AggregateId(taskId))
    }
}