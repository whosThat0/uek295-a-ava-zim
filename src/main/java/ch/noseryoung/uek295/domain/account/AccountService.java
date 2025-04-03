package ch.noseryoung.uek295.domain.account;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account updateById(UUID id, Account account) throws NoSuchElementException {
        if (repository.existsById(id)) {
            account.setId(id);
            log.info("Updating account with id: " + id);
            return repository.save(account);
        }
        throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
    }

    public Account getAccountById(UUID accountId){
        Optional<Account> existingAccount = repository.findById(accountId);
        if (existingAccount.isPresent()){
            log.info("Account with ID '{}' found", accountId);
            return existingAccount.get();
        }
        throw new NoSuchElementException("Account with ID " + accountId + " not found");
    }

    public List<Account> allAccounts(){
        log.info("got all accounts");
        repository.findAll().forEach(System.out::println);
        return repository.findAll();
    }

}
