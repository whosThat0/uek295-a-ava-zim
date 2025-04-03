package ch.noseryoung.uek295.domain.account;

import jakarta.validation.Valid;
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

    @GetMapping("/account")//works
    public List<Account> getAccounts() {
        return service.allAccounts();
    }

    @GetMapping("/account/{id}")//works
    public Account getAccount(@Valid @PathVariable UUID id) {
        return service.getAccountById(id);
    }

    @PostMapping("/account") //works
    public void addAccount(@Valid @RequestBody Account account) {
        accountRepository.save(account);
    }

    @DeleteMapping("/account/{id}") //works
    public void deleteAccountWithID(@Valid @PathVariable UUID id) {
        log.info("Deleting account with ID: " + id);
        accountRepository.deleteById(id);
    }

    @PutMapping("/account/{id}") //works
    public Account updateAccounts(@Valid @PathVariable String id, @RequestBody Account account) {
        return service.updateById(UUID.fromString(id), account);
    }
}

