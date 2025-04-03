package ch.noseryoung.uek295.domain.account;
import ch.noseryoung.uek295.domain.account.locale.Locale;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
@SpringBootApplication

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private UUID id;
    @NotBlank
    @NotEmpty
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
    @Getter
    @Column(name = "email")
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    @Length(min = 7, max = 30)
    @Getter
    @Column(name = "password")
    private String password;
    @PastOrPresent
    @Getter
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "id_locale")
    private UUID id_locale;

    @ManyToOne
    @JoinColumn(name = "locale_locale_id")
    private Locale locale;

    public Account(UUID id, String email, String password, Date created_at) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }
}
