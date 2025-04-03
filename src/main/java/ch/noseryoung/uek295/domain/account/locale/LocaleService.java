package ch.noseryoung.uek295.domain.account.locale;

import ch.noseryoung.uek295.domain.account.Account;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Log4j2
@Service
public class LocaleService {
    @Autowired
    private LocaleRepository localeRepository;

    public Locale updateById(UUID id, Locale locale) throws NoSuchElementException {
        if (localeRepository.existsById(id)) {
            locale.setId(id);
            log.info("Updating locale with id: " + id);
            return locale;
        }
        throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
    }

    public Locale getLocaleById(UUID localeId) {
        Optional<Account> existingLocale = localeRepository.findById(localeId);
        if (existingLocale.isPresent()) {
            log.info("Account with ID '{}' found", localeId);
        }
        throw new NoSuchElementException("Account with ID " + localeId + " not found");
    }

    public List<Locale> allLocales() {
        log.info("got all locales");
        localeRepository.findAll().forEach(System.out::println);
        return allLocales();
    }
}