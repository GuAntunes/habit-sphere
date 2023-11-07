package br.com.gustavoantunes.habitspheredomain.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import java.util.UUID

class AccountTest {

    @Test
    fun testValidAccount() {
        val account = Account(
            id = UUID.randomUUID(),
            username = "validuser",
            email = "user@example.com",
            password = "password123"
        )

        assertEquals("validuser", account.username)
    }

    @Test
    fun testInvalidUsername() {
        assertThrows(IllegalArgumentException::class.java) {
            Account(
                id = UUID.randomUUID(),
                username = "",
                email = "user@example.com",
                password = "password123"
            )
        }
    }

    @Test
    fun testInvalidEmail() {
        assertThrows(IllegalArgumentException::class.java) {
            Account(
                id = UUID.randomUUID(),
                username = "validuser",
                email = "",
                password = "password123"
            )
        }
    }

    @Test
    fun testInvalidPassword() {
        assertThrows(IllegalArgumentException::class.java) {
            Account(
                id = UUID.randomUUID(),
                username = "validuser",
                email = "user@example.com",
                password = ""
            )
        }
    }
}