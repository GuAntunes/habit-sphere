package br.com.gustavoantunes.habitsphereadapters.adapter.resource.request

import br.com.gustavoantunes.habitspheredomain.model.Account
import br.com.gustavoantunes.habitspheredomain.model.accountOf
import java.util.UUID

data class AccountUpdateRequest(
    val id: UUID,
    val username: String,
    val email: String,
    val password: String
) {
    fun toAccount(): Account =
        accountOf(
            id = id,
            username = username,
            email = email,
            password = password
        )
}
