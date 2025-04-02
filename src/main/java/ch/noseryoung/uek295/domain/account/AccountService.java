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

    /*public Account updateAccount(UUID accountId, Account accountUpdate){
        Optional<Account> existingAccount = repository.findById(accountId);
        if (existingAccount.isPresent()){
            Account updatedAccount = existingAccount.get();
            updatedAccount.setEmail(accountUpdate.getEmail());
            log.info("successfully updated email");
            updatedAccount.setPassword(accountUpdate.getPassword());
            log.info("successfully updated password");
            repository.save(updatedAccount);
        } else {
            log.error("Update failed: Account {} not found", accountId);
            throw new NoSuchElementException("Account with ID " + accountId + " not found");
        }
        return repository.save(accountUpdate);
    }*/

    public Account updateById(UUID id, Account account) throws NoSuchElementException {
        if (repository.existsById(id)) {
            account.setId(id);
            return repository.save(account);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    public Account createAccount(Account account){
        return repository.save(account);
    }

    public Account getAccountById(UUID accountId){
        Optional<Account> existingAccount = repository.findById(accountId);
        if (existingAccount.isPresent()){
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
