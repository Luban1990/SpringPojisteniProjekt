package pojistovna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Třída která zobrazje šablonu about, contact//

@Controller
public class InfoController {

    @GetMapping("/about")
    public String zobrazInfo(){
        return "about";
    }

    @GetMapping("/contact")
    public String zobrazKontakt() {
        return "contact";
    }
}
