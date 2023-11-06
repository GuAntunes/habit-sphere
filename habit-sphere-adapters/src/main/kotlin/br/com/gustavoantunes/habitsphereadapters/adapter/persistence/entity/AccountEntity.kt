package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.entity

import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.Aggregate
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateId
import br.com.gustavoantunes.habitspheredomain.model.Account
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("account")
data class AccountEntity(
    @Id
    override val id: AggregateId = AggregateId(),
    val username: String,
    val email: String,
    val password: String
) : Aggregate() {
    fun toAccount(): Account {
        return Account(
            id = id.toUUID(),
            username = username,
            email = email,
            password = password
        )
    }
}

fun accountEntityOf(account: Account): AccountEntity {
    return AccountEntity(
        id = AggregateId(account.id),
        username = account.username,
        email = account.email,
        password = account.password
    )
}
