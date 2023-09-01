package patient.in.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/msg")
    public String getWelcomeMsg(){
        return "Welcome to india";
    }
}
