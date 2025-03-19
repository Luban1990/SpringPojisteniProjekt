package pojistovna.models.services;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojistovna.data.entity.PojistenecEntity;
import pojistovna.data.entity.PojisteniEntity;
import pojistovna.data.repositories.PojistenecRepository;
import pojistovna.data.repositories.PojisteniRepository;

import java.util.List;
import java.util.Optional;

// Anotace @Service označuje tuto třídu jako servisní vrstvu v aplikaci Spring.
@Service
public class PojistenecServiceImpl implements PojistenecService{

    // Repozitář pro práci s entitou PojistenecEntity.
    private PojistenecRepository repository;
    // Repozitář pro práci s entitou PojisteniEntity, slouží k manipulaci s pojištěními.
    private PojisteniRepository pojisteniRepository;

    // Konstruktor pro injektování závislostí (repozitářů) do této třídy.
    public PojistenecServiceImpl(PojistenecRepository repository,PojisteniRepository pojisteniRepository ) {
        this.repository = repository;
        this.pojisteniRepository = pojisteniRepository;
    }

    // přepsané metody
    @Override
    public List<PojistenecEntity> vsichniKlienti() {
        return repository.findAll();
    }

    @Override
    public Optional<PojistenecEntity> klientiPodleId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void ulozKlienta(PojistenecEntity pojistenec) {
        repository.save(pojistenec);

    }
    @Override
    public void smazKlienta(Long id) {
        // Získáme všechna pojištění daného pojištěnce
        List<PojisteniEntity> pojisteniList = pojisteniRepository.findByPojistenec_Id(id);

        if (!pojisteniList.isEmpty()) {
            pojisteniRepository.deleteAll(pojisteniList);
        } else {

        }

        // Pak smažeme samotného pojištěnce
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }

    }
}
