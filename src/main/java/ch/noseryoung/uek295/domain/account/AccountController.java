package ch.noseryoung.uek295.domain.account;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Log4j2
@RestController
public class AccountController {
    @Autowired
    private AccountService service;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String index() {
        return "Welcome to the Account Manager!";

    }

    @GetMapping("/account")
    public List<Account> getAccounts() {
        return service.allAccounts();
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable UUID id) {
        return service.getAccountById(id);
    }

    @PostMapping("/account")
    public void addAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccountWithID(@PathVariable UUID id) {
        log.info("Deleting account with ID: " + id);
        accountRepository.deleteById(id);
    }

    @PutMapping("/account/{id}")
    public Account updateAccounts(@PathVariable UUID ID, @RequestBody Account account) {
        return service.updateById(ID, account);
    }
}

