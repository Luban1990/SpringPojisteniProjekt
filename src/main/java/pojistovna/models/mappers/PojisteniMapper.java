package pojistovna.models.mappers;

import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pojistovna.data.entity.PojisteniEntity;
import pojistovna.models.dto.PojisteniDTO;
// Rozhraní PojistenecMapper slouží pro mapování mezi entitou PojistenecEntity a datovým přenosovým objekt
@Mapper(componentModel = "spring")
public interface PojisteniMapper {

    // Metoda mapuje entitu PojisteniEntity na DTO objekt PojisteniDTO.
    // Anotace @Mapping určuje, že pole pojistenecJmeno v DTO bude naplněno z pole jmeno v objektu pojistenec (součást entity).
    // Stejně tak se pojistenecPrijmeni naplní z pojistenec.prijmeni.
    @Mapping(target = "pojistenecJmeno", source = "pojistenec.jmeno")
    @Mapping(target = "pojistenecPrijmeni", source = "pojistenec.prijmeni")
    PojisteniDTO toDTO(PojisteniEntity pojisteniEntity);

    // Metoda převádí DTO objekt PojisteniDTO zpět na entitu PojisteniEntity.
    PojisteniEntity toEntity(PojisteniDTO pojisteniDTO);

    // Metoda aktualizuje existující objekt PojisteniDTO na základě hodnot z jiného DTO objektu.
    // Používá se k částečné aktualizaci dat bez nutnosti vytvářet nový objekt.
    void updatePojisteniDTO(PojisteniDTO pojisteniDTO, @MappingTarget PojisteniDTO target);

    // Umožňuje úpravu údajů v databázové entitě bez jejího kompletního přepsání.
    void updatePojisteniEntity(PojisteniDTO pojisteniDTO, @MappingTarget PojisteniEntity target);
}





