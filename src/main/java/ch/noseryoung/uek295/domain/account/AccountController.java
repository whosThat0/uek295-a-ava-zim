package ch.noseryoung.uek295.domain.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/")
    public String index() {
        return "Book Store! "+
                "Welcome to the Store!"  ;
    }
}
