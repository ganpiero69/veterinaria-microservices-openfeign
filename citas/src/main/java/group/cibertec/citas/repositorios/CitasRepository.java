package group.cibertec.citas.repositorios;

import group.cibertec.citas.entidades.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitasRepository extends JpaRepository<CitaEntity, Long>{
}
