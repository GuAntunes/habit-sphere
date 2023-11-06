package br.com.gustavoantunes.habitsphereadapters.adapter.resource

import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.AccountCreateRequest
import br.com.gustavoantunes.habitsphereadapters.adapter.resource.request.AccountUpdateRequest
import br.com.gustavoantunes.habitsphereadapters.port.AccountRestPort
import br.com.gustavoantunes.habitsphereapplication.service.AccountService
import br.com.gustavoantunes.habitspheredomain.model.Account
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/account")
class RestAccountControllerAdapter(private val accountService: AccountService) : AccountRestPort {

    @GetMapping("/list")
    override fun getAllAccount(): List<Account> {
        return accountService.getAllAccounts()
    }

    @GetMapping("/{accountId}")
    override fun getAccountById(@PathVariable accountId: UUID): Account? {
        return accountService.getAccountById(accountId)
    }

    @PostMapping
    override fun createAccount(@RequestBody account: AccountCreateRequest): Account {
        return accountService.createAccount(account.toAccount())
    }

    @PutMapping
    override fun updateTask(@RequestBody updatedAccount: AccountUpdateRequest): Account {
        return accountService.updateAccount(updatedAccount.toAccount())
    }

    @DeleteMapping("/{taskId}")
    override fun deleteTask(@PathVariable accountId: UUID) {
        return accountService.deleteAccount(accountId)
    }
}
