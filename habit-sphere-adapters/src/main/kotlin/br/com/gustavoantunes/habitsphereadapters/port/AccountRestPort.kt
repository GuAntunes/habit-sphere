package br.com.gustavoantunes.habitsphereadapters.port

import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.AccountCreateRequest
import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.AccountUpdateRequest
import br.com.gustavoantunes.habitspheredomain.model.Account
import java.util.UUID

interface AccountRestPort {
    fun getAllAccount(): List<Account>
    fun getAccountById(accountId: UUID): Account?
    fun createAccount(account: AccountCreateRequest): Account
    fun updateTask(updatedAccount: AccountUpdateRequest): Account
    fun deleteTask(accountId: UUID)
}