package pojistovna.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pojistovna.models.dto.PojisteniDTO;
import pojistovna.models.services.PojistenecService;
import pojistovna.models.services.PojisteniService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

// Controller který obsluhuje pojištění
@Controller
@RequestMapping("/pojisteni")
public class PojisteniController    {


    private PojisteniService service;
    private PojistenecService pojistenecService;

    // Construktor - Constructor - injection namísto @Autowierd
    public PojisteniController(PojisteniService service, PojistenecService pojistenecService) {
        this.service = service;
        this.pojistenecService = pojistenecService;
    }


    //Zobrazí seznam pojištění
    @GetMapping
    public String zobrazSeznamPojisteni(Model model) {
        List<PojisteniDTO> pojisteniList = service.vsechnaPojisteni();
        model.addAttribute("pojisteni", pojisteniList);
        return "pojisteni/index";
    }

    // zobrazí formulář k přidání nového pojištění
    @GetMapping("/pridat")
    public String zobrazFormularPridani(Model model) {
        model.addAttribute("pojisteni", new PojisteniDTO());
        model.addAttribute("pojistenci", pojistenecService.vsichniKlienti());
        return "pojisteni/pridat";
    }

    //Metoda pro uložení nového pojištění
    @PostMapping("/ulozit")
    public String ulozPojisteni(@ModelAttribute("pojisteni") @Valid PojisteniDTO pojisteniDTO, BindingResult result, RedirectAttributes redirectAttributes, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pojistenci", pojistenecService.vsichniKlienti());
            return "pojisteni/pridat";
        }
        service.ulozPojisteni(pojisteniDTO);
        redirectAttributes.addFlashAttribute("pridano","Záznam byl přidán");
        return "redirect:/pojisteni";
    }

    //Formulář pro editaci pojištění - již existujícího
    @GetMapping("/edit/{id}")
    public String zobrazFormularEditace(@PathVariable Long id, Model model) {
        Optional<PojisteniDTO> pojisteniDTO = service.pojisteniPodleId(id);
        if (pojisteniDTO.isPresent()) {
            model.addAttribute("pojisteni", pojisteniDTO.get());
            model.addAttribute("pojistenci", pojistenecService.vsichniKlienti()); // Přidání seznamu pojištěnců
            return "pojisteni/edit";
        } else {
            return "redirect:/pojisteni";
        }
    }


    //Metoda pro uložení změn pojištění
    @PostMapping("/edit/{id}")
    public String aktualizujPojisteni(@PathVariable Long id,
                                      @ModelAttribute("pojisteni") @Valid PojisteniDTO pojisteniDTO,
                                      BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "pojisteni/edit";
        }

        pojisteniDTO.setId(id);
        service.ulozPojisteni(pojisteniDTO);

        redirectAttributes.addFlashAttribute("upraveno","Záznam byl upraven");
        return "redirect:/pojisteni";
    }



    //Metoda pro mazání pojištění.
    @GetMapping("/smazat/{id}")
    public String smazatPojisteni(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        service.smazPojisteni(id);
        redirectAttributes.addFlashAttribute("smazano","Záznam byl smazán");
        return "redirect:/pojisteni";  // Přesměrování zpět na seznam
    }
}
