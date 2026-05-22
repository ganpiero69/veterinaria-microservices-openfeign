package group.cibertec.mascotas.service;

import group.cibertec.mascotas.entity.Mascota;
import group.cibertec.mascotas.repository.MascotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public Mascota guardarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    public Optional<Mascota> obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id);
    }
}