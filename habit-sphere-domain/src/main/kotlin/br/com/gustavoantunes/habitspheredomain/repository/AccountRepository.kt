package br.com.gustavoantunes.habitspheredomain.repository

import br.com.gustavoantunes.habitspheredomain.model.Account
import java.util.UUID

interface AccountRepository {
    fun getAllAccounts(): List<Account>
    fun getAccountById(accountId: UUID): Account?
    fun createAccount(account: Account): Account
    fun updateAccount(updatedAccount: Account): Account
    fun deleteAccount(accountId: UUID)
}