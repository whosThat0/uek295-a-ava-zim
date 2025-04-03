package ch.noseryoung.uek295.domain.account;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;

@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0", description = "API Documentation"))
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Account.class, args);
    }
}
