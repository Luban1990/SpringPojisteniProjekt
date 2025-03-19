package pojistovna.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// třída která zobrauje šablonu index pro hlavní stránku//

@Controller
public class HomeController {

    @GetMapping("/")
   public String zobrazUvodniStranku(){
       return "index";
   }

}
