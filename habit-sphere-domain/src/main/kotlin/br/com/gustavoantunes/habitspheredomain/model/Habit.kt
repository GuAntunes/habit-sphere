package br.com.gustavoantunes.habitspheredomain.model

import java.util.UUID

data class Habit(
    val id: UUID,
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
