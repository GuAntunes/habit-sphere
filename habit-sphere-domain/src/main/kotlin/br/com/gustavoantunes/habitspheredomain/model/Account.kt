package br.com.gustavoantunes.habitspheredomain.model

import java.util.UUID

fun accountOf(
    id: UUID = UUID.randomUUID(),
    username: String,
    email: String,
    password: String
): Account =
    Account(
        id = id,
        username = username,
        email = email,
        password = password
    )

data class Account(
    val id: UUID,
    val username: String,
    val email: String,
    val password: String
) {
    init {
        require(username.isNotBlank()) { "Username cannot be blank." }
        require(email.isNotBlank()) { "Email cannot be blank." }
        require(password.isNotBlank()) { "Password cannot be blank." }
    }
}