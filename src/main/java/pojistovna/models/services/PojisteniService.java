package pojistovna.models.services;

import pojistovna.models.dto.PojisteniDTO;

import java.util.List;
import java.util.Optional;
// Interface obsahující hlavičky metod pro správu pojištění
public interface PojisteniService  {


    List<PojisteniDTO> vsechnaPojisteni();

    Optional<PojisteniDTO>pojisteniPodleId(Long id);

    List<PojisteniDTO> pojisteniProPojistence(Long pojistenecId);

    void ulozPojisteni(PojisteniDTO pojisteniDTO);

    void smazPojisteni(Long id);
}
