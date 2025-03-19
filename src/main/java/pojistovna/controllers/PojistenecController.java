package pojistovna.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pojistovna.data.entity.PojistenecEntity;
import pojistovna.models.dto.PojistenecDTO;
import pojistovna.models.mappers.PojistenecMapper;
import pojistovna.models.services.PojistenecService;

import java.util.List;
import java.util.Optional;
// Controler pro správu pojištěnce

@Controller
@RequestMapping("/pojistenci")  // Prefix pro všechny operace s pojištěnci
public class PojistenecController {

    private final PojistenecService service;
    private final PojistenecMapper pojistenecMapper;

    // Construktor - Constructor injection namísto @Autowierd
    public PojistenecController(PojistenecService service, PojistenecMapper pojistenecMapper) {
        this.service = service;
        this.pojistenecMapper = pojistenecMapper;
    }

    // metoda pro zobrazení seznamu Pojištěnců
    @GetMapping
    public String zobrazSeznamPojistencu(Model model) {
        List<PojistenecDTO> pojistenci = service.vsichniKlienti()
                .stream()
                .map(pojistenecMapper::toDTO)
                .toList();
        model.addAttribute("pojistenci", pojistenci);
        return "pojistenec/index";
    }
// Formulář pro přidání klienta
    @GetMapping("/pridat")
    public String zobrazFormularPridani(Model model) {
        model.addAttribute("pojistenec", new PojistenecDTO());
        return "pojistenec/pridat";
    }

   // metoda pro uložení klienta
    @PostMapping("/ulozit")
    public String ulozPojistence(@ModelAttribute("pojistenec") @Valid PojistenecDTO pojistenecDTO, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            return "pojistenec/pridat";
        }

        PojistenecEntity entity = pojistenecMapper.toEntity(pojistenecDTO);
        service.ulozKlienta(entity);
        redirectAttributes.addFlashAttribute("pridano","Nový klient byl uložen");
        return "redirect:/pojistenci";
    }

  // Formulář k editaci klienta
    @GetMapping("/edit/{id}")
    public String zobrazFormularEditace(@PathVariable Long id, Model model) {
        Optional<PojistenecEntity> pojistenecEntity = service.klientiPodleId(id);

        if (pojistenecEntity.isPresent()) {
            PojistenecDTO pojistenecDTO = pojistenecMapper.toDTO(pojistenecEntity.get());
            model.addAttribute("pojistenec", pojistenecDTO);
            return "pojistenec/edit";
        } else {
            return "redirect:/pojistenci";
        }
    }

 //Metoda pro uložení změn u extistujícího klienta
    @PostMapping("/edit/{id}")
    public String aktualizujPojistence(@PathVariable Long id, @ModelAttribute("pojistenec") @Valid PojistenecDTO pojistenecDTO, BindingResult result,RedirectAttributes redirectAttributes) {
            if (result.hasErrors()) {
                return "pojistenec/edit";
            }
            // optional - obalovací třída, hezky pracuje s null
            Optional<PojistenecEntity> pojistenecEntity = service.klientiPodleId(id);
            if (pojistenecEntity.isPresent()) {
                pojistenecMapper.updatePojistenecEntity(pojistenecDTO, pojistenecEntity.get());
                service.ulozKlienta(pojistenecEntity.get());
            }

            redirectAttributes.addFlashAttribute("upraveno","Záznam byl upraven");
            return "redirect:/pojistenci";
    }

  // metoda pro mazání klienta
    @GetMapping("/smazat/{id}")
    public String smazatPojistence(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        service.smazKlienta(id);
        redirectAttributes.addFlashAttribute("smazano","klient byl smazán, a společně s ním také jeho pojištění!( pokud ho měl)");
        return "redirect:/pojistenci";
    }
}