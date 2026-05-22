package group.cibertec.citas.services;

import group.cibertec.citas.services.dtos.CitaDto;
import group.cibertec.citas.entidades.CitaEntity;

import java.util.List;

public interface CitaService {
    void guardarCita(CitaDto dto);
    List<CitaEntity> obtenerTodasCitasConMascotas();
}
