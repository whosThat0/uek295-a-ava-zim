package ch.noseryoung.uek295.domain.account;
import ch.noseryoung.uek295.domain.account.locale.LocaleService;
import io.swagger.v3.oas.annotations.Operation;
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
    private LocaleService localeService;
    @Autowired
    private AccountService service;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    @Operation (summary = "This is the normal first Page")
    public String index() {
        return "Welcome to the Account Manager!";

    }

    @GetMapping("/account")//works
    @Operation (summary = "This shows all the Accounts in the SQL Database")
    public List<Account> getAccounts() {
        return service.allAccounts();
    }

    @GetMapping("/account/{id}")//works
    @Operation (summary = "This shows the Account with the id which is in URL")
    public Account getAccount(@Valid @PathVariable UUID id) {
        return service.getAccountById(id);
    }

    @PostMapping("/account") //works
    @Operation (summary = "This saves an Account with the Info which is in the Body. The Data will be Validated")
    public void addAccount(@Valid @RequestBody Account account) {
        log.info("created Account: {}", account);
        accountRepository.save(account);
    }

    @DeleteMapping("/account/{id}") //works
    @Operation (summary = "This deletes the Account via the ID")
    public void deleteAccountWithID(@Valid @PathVariable UUID id) {
        accountRepository.deleteById(id);
    }

    @PutMapping("/account/{id}") //works
    @Operation (summary = "This will update the Account via the Data in the body and it will take the " +
                "Account with the matching ID as in the URL")
    public Account updateAccounts(@Valid @PathVariable String id, @RequestBody Account account) {
        return service.updateById(UUID.fromString(id), account);
    }
}

