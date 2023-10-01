package br.com.gustavoantunes.habitspheredomain.models

data class Habit(
    val id: Long,
    val name: String,
    val description: String?,
    val frequency: HabitFrequency,
    val progress: HabitProgress
)

enum class HabitFrequency {
    DAILY, WEEKLY, CUSTOM
}

data class HabitProgress(
    val completedOccurrences: Int,
    val totalOccurrences: Int
)
