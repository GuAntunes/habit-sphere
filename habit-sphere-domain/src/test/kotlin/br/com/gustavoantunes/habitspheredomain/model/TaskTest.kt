package br.com.gustavoantunes.habitspheredomain.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID
import java.time.LocalDateTime

class TaskRepositoryTest {

    @Test
    fun testValidTask() {
        val task = Task(
            id = UUID.randomUUID(),
            accountId = UUID.randomUUID(),
            title = "Valid Title",
            description = "Description",
            dueDate = LocalDateTime.now(),
            priority = Priority.LOW,
            status = TaskStatus.INCOMPLETE,
            category = Category.WORK
        )

        assertEquals("Valid Title", task.title)
    }

    @Test
    fun testInvalidTaskTitle() {
        assertThrows<IllegalArgumentException> {
            Task(
                id = UUID.randomUUID(),
                accountId = UUID.randomUUID(),
                title = "",
                description = "Description",
                dueDate = LocalDateTime.now(),
                priority = Priority.LOW,
                status = TaskStatus.INCOMPLETE,
                category = Category.WORK
            )
        }
    }
}