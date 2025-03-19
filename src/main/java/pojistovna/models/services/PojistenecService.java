package pojistovna.models.services;

import pojistovna.data.entity.PojistenecEntity;

import java.util.List;
import java.util.Optional;

//Rozhraní s hlavičkami metod

public interface PojistenecService {

   public List<PojistenecEntity> vsichniKlienti();

   public Optional<PojistenecEntity>klientiPodleId(Long id);

    void ulozKlienta(PojistenecEntity pojistenec);

    void smazKlienta(Long id);





}
