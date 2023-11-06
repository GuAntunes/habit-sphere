package br.com.gustavoantunes.habitsphereadapters.adapter.resource.request

import br.com.gustavoantunes.habitspheredomain.model.Account
import br.com.gustavoantunes.habitspheredomain.model.accountOf
import java.util.UUID

data class AccountCreateRequest(
    val username: String,
    val email: String,
    val password: String
) {
    fun toAccount(): Account =
        accountOf(
            username = username,
            email = email,
            password = password
        )
}