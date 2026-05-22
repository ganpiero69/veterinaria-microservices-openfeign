package group.cibertec.citas.services.mappers;

import group.cibertec.citas.services.dtos.CitaDto;
import group.cibertec.citas.entidades.CitaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    CitaEntity toEntity(CitaDto dto);
    CitaDto toDto(CitaEntity entity);
}
