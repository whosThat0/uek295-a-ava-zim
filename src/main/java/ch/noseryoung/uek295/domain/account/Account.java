package ch.noseryoung.uek295.domain.account;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
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
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private UUID id;
    @Getter
    @Column(name = "email")
    private String email;
    //validation
    @Getter
    @Column(name = "password")
    private String password;
    @Getter
    @Column(name = "created_at")
    private Date created_at;

    public Account(UUID id, String email, String password, Date created_at) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }
}
