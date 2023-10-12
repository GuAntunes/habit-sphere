package br.com.gustavoantunes.habitsphereadapters.adapter.resource.request

import br.com.gustavoantunes.habitspheredomain.model.Category
import br.com.gustavoantunes.habitspheredomain.model.Priority
import br.com.gustavoantunes.habitspheredomain.model.Task
import br.com.gustavoantunes.habitspheredomain.model.TaskStatus
import br.com.gustavoantunes.habitspheredomain.model.taskOf
import java.time.LocalDateTime

data class TaskCreateRequest(
    val title: String,
    val description: String?,
    val dueDate: LocalDateTime,
    val priority: String,
    val status: String,
    val category: String
) {
    fun toTask(): Task =
        taskOf(
            title = title,
            description = description,
            dueDate = dueDate,
            priority = Priority.valueOf(priority),
            status = TaskStatus.valueOf(status),
            category = Category.valueOf(category)
        )
}