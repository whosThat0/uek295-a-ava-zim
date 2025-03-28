package ch.noseryoung.uek295.domain.account;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
@SpringBootApplication

public class Account {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;
    @Column(name = "email")
    //TODO: make a check for an '@' in email
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "date")
    private Date date;


}
