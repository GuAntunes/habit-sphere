package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.entity

import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.Aggregate
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateId
import br.com.gustavoantunes.habitspheredomain.model.Category
import br.com.gustavoantunes.habitspheredomain.model.Priority
import br.com.gustavoantunes.habitspheredomain.model.Task
import br.com.gustavoantunes.habitspheredomain.model.TaskStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.util.*

@Table("task")
data class TaskEntity(
    @Id
    override val id: AggregateId = AggregateId(),
    val title: String,
    val description: String? = null,
    val dueDate: LocalDateTime,
    val priority: String,
    val status: String,
    val category: String
) : Aggregate() {
    fun toTask(): Task {
        return Task(
            id = id.toUUID(),
            title = title,
            description = description,
            dueDate = dueDate,
            priority = Priority.valueOf(priority),
            status = TaskStatus.valueOf(status),
            category = Category.valueOf(category)
        )
    }
}

fun taskEntityOf(task: Task): TaskEntity {
    return TaskEntity(
        id = AggregateId(task.id),
        title = task.title,
        description = task.description,
        dueDate = task.dueDate,
        priority = task.priority.name,
        status = task.status.name,
        category = task.category.name
    )
}
