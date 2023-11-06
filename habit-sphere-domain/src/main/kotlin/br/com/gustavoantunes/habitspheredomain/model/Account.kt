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
)   