package ch.noseryoung.uek295.domain.account.locale;
import ch.noseryoung.uek295.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocaleRepository extends JpaRepository<Account, UUID> {
}