package br.com.gustavoantunes.habitsphereapplication.service

import br.com.gustavoantunes.habitspheredomain.model.Account
import br.com.gustavoantunes.habitspheredomain.repository.AccountRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountService(private val accountRepository: AccountRepository) {

    fun getAllAccounts(): List<Account> {
        return accountRepository.getAllAccounts()
    }

    fun getAccountById(accountId: UUID): Account? {
        return accountRepository.getAccountById(accountId)
    }

    fun createAccount(account: Account): Account {
        return accountRepository.createAccount(account)
    }

    fun updateAccount(updatedAccount: Account): Account {
        return accountRepository.updateAccount(updatedAccount)
    }

    fun deleteAccount(accountId: UUID) {
        accountRepository.deleteAccount(accountId)
    }
}