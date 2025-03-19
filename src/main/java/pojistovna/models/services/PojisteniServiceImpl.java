package pojistovna.models.services;

import org.springframework.stereotype.Service;
import pojistovna.data.entity.PojistenecEntity;
import pojistovna.data.entity.PojisteniEntity;
import pojistovna.data.repositories.PojistenecRepository;
import pojistovna.data.repositories.PojisteniRepository;
import pojistovna.models.dto.PojisteniDTO;
import pojistovna.models.mappers.PojisteniMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // Anotace pro SB, aby věděl, že se jedná o Servisní třídu
public class PojisteniServiceImpl implements PojisteniService {

    // Repozitáře obou entit, mapper,
    private  PojisteniRepository repository;
    private PojisteniMapper mapper;
    private PojistenecRepository pojistenecRepository;

    // Construcotr- injection - namísto @Autowierd
    public PojisteniServiceImpl(PojisteniRepository repository, PojisteniMapper mapper, PojistenecRepository pojistenecRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.pojistenecRepository=pojistenecRepository;
    }


    @Override
    public List<PojisteniDTO> vsechnaPojisteni() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PojisteniDTO> pojisteniPodleId(Long id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Override
    public List<PojisteniDTO> pojisteniProPojistence(Long pojistenecId) {
        return repository.findByPojistenec_Id(pojistenecId).stream().map(mapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void ulozPojisteni(PojisteniDTO pojisteniDTO) {
        PojisteniEntity entity;

        if (pojisteniDTO.getId() != null) {
            Optional<PojisteniEntity> existujiciPojisteni = repository.findById(pojisteniDTO.getId());

            if (existujiciPojisteni.isPresent()) {
                entity = existujiciPojisteni.get();
            } else {
                throw new RuntimeException("Pojištění s ID " + pojisteniDTO.getId() + " nebylo nalezeno!");
            }
        } else {
            entity = new PojisteniEntity();
        }

        // Nastavení hodnot z DTO
        entity.setTyp(pojisteniDTO.getTyp());
        entity.setCastka(pojisteniDTO.getCastka());
        entity.setDatumOd(pojisteniDTO.getDatumOd());
        entity.setDatumDo(pojisteniDTO.getDatumDo());

        //  Ověření, že existuje pojištěnec (abychom předešli chybě)
        Optional<PojistenecEntity> pojistenec = pojistenecRepository.findById(pojisteniDTO.getPojistenecId());
        if (pojistenec.isPresent()) {
            entity.setPojistenec(pojistenec.get());
        } else {
            throw new RuntimeException("Pojištěnec s ID " + pojisteniDTO.getPojistenecId() + " nebyl nalezen!");
        }

        // Uložení do databáze
        repository.save(entity);


        // Aktualizujeme hodnoty
        entity.setTyp(pojisteniDTO.getTyp());
        entity.setCastka(pojisteniDTO.getCastka());
        entity.setDatumOd(pojisteniDTO.getDatumOd());
        entity.setDatumDo(pojisteniDTO.getDatumDo());

        // Pojištěnce neměníme při editaci!
        repository.save(entity);
    }


    @Override
    public void smazPojisteni(Long id) {
        repository.deleteById(id);
    }
}
