package ch.noseryoung.uek295.domain.account.locale;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "locale")

public class Locale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "locale_id", nullable = false)
    private UUID id;
    @Getter
    @Column(name = "language")
    private String language;
    @Getter
    @Column(name = "location")
    private String location;
    @Getter
    @Column(name = "currency")
    private String currency;

    public Locale(UUID id, String language, String location, String currency) {
        this.id = id;
        this.language = language;
        this.location = location;
        this.currency = currency;
    }
}
