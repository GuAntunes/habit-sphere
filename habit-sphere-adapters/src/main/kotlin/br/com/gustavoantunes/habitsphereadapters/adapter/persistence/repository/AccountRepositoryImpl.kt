package br.com.gustavoantunes.habitsphereadapters.adapter.persistence.repository

import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.common.AggregateId
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.entity.accountEntityOf
import br.com.gustavoantunes.habitsphereadapters.adapter.persistence.repository.jpa.AccountJpaRepository
import br.com.gustavoantunes.habitspheredomain.model.Account
import br.com.gustavoantunes.habitspheredomain.repository.AccountRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AccountRepositoryImpl(
    private val accountJpaRepository: AccountJpaRepository
) : AccountRepository {
    override fun getAllAccounts(): List<Account> {
        return accountJpaRepository.findAll().map { it.toAccount() }
    }

    override fun getAccountById(accountId: UUID): Account? {
        return accountJpaRepository.findById(AggregateId(accountId)).orElse(null)?.toAccount()
    }

    override fun createAccount(account: Account): Account {
        return accountJpaRepository.insert(accountEntityOf(account)).toAccount()
    }

    override fun updateAccount(updatedAccount: Account): Account {
        return accountJpaRepository.update(accountEntityOf(updatedAccount)).toAccount()
    }

    override fun deleteAccount(accountId: UUID) {
        return accountJpaRepository.deleteById(AggregateId(accountId))
    }
}