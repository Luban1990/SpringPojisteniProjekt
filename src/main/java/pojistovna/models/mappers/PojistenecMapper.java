package pojistovna.models.mappers;


import ch.qos.logback.core.model.ComponentModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pojistovna.data.entity.PojistenecEntity;
import pojistovna.models.dto.PojistenecDTO;

// Rozhraní PojistenecMapper slouží pro mapování mezi entitou PojistenecEntity a datovým přenosovým objektem PojistenecDTO.

@Mapper(componentModel = "spring")
public interface PojistenecMapper {

     // Převody mezi entitou a DTO

    PojistenecEntity toEntity(PojistenecDTO pojistenecDTO);

    PojistenecDTO toDTO(PojistenecEntity pojistenecEntity);

    void updatePojistenecDTO(PojistenecDTO pojistenecDTO, @MappingTarget PojistenecDTO target);

    void updatePojistenecEntity(PojistenecDTO pojistenecDTO, @MappingTarget PojistenecEntity target);
}



