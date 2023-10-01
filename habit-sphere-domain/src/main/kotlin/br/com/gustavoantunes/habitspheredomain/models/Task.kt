package br.com.gustavoantunes.habitspheredomain.models

data class Task(
    val id: Long,
    val title: String,
    val description: String?,
    val dueDate: Long,
    val priority: Priority,
    val status: TaskStatus,
    val categoryId: Category
)

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
