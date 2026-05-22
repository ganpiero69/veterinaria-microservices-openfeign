package group.cibertec.citas.services;

import group.cibertec.citas.services.dtos.CitaDto;
import group.cibertec.citas.entidades.CitaEntity;
import group.cibertec.citas.feign.clients.MascotaClient;
import group.cibertec.citas.feign.dtos.MascotaDto;
import group.cibertec.citas.repositorios.CitasRepository;
import group.cibertec.citas.services.mappers.CitaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CitaServiceImp implements CitaService{

    private final CitasRepository _citaRepository;
    private final MascotaClient _mascotaClient;
    private final CitaMapper _citaMapper;

    @Transactional
    @Override
    public void guardarCita(CitaDto dto) {
        MascotaDto mascota = _mascotaClient.obtenerMascotaPorId(dto.idMascota());

        if(mascota == null){
            throw new NullPointerException("La mascota no existe.");
        }

        CitaEntity entity = _citaMapper.toEntity(dto);

        System.out.println(entity);
        System.out.println(dto);

        entity.setNombreMascota(mascota.nombre());
        entity.setNombreDuenio(mascota.nombreDuenio());

        if (entity.getEstado() == null) {
            entity.setEstado("PROGRAMADA");
        }

        _citaRepository.save(entity);
    }

    @Override
    public List<CitaEntity> obtenerTodasCitasConMascotas() {
        List<CitaEntity> citas = _citaRepository.findAll();

        citas.stream().forEach(c -> {
            MascotaDto mascota = _mascotaClient.obtenerMascotaPorId(c.getIdMascota());

            System.out.println(mascota);
            System.out.println("Nombre del duenio de la mascota: "+ mascota.nombreDuenio());
            System.out.println("Nombre del duenio: "+ mascota.nombre());

            c.setNombreDuenio(mascota.nombreDuenio());
            c.setNombreMascota(mascota.nombre());
        });

        return citas;
    }
}
