package group.cibertec.mascotas.repository;

import group.cibertec.mascotas.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}