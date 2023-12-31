package br.com.gustavoantunes.habitspheredomain.model

import java.time.LocalDateTime
import java.util.UUID
import java.util.UUID.randomUUID

fun taskOf(
    id: UUID = randomUUID(),
    accountId: UUID,
    title: String,
    description: String?,
    dueDate: LocalDateTime,
    priority: Priority,
    status: TaskStatus,
    category: Category
): Task =
    Task(
        id = id,
        accountId = accountId,
        title = title,
        description = description,
        dueDate = dueDate,
        priority = priority,
        status = status,
        category = category
    )

data class Task(
    val id: UUID,
    val accountId: UUID,
    val title: String,
    val description: String?,
    val dueDate: LocalDateTime,
    val priority: Priority,
    val status: TaskStatus,
    val category: Category
) {
    init {
        require(title.isNotBlank()) { "O título da tarefa não pode estar em branco." }
    }
}

enum class Priority {
    LOW, MEDIUM, HIGH
}

enum class TaskStatus {
    INCOMPLETE, COMPLETED, IN_PROGRESS
}

enum class Category {
    WORK,
    PERSONAL,
    HEALTH,
    HOME,
}
