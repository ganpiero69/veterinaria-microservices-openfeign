package group.cibertec.citas.feign.clients;

import group.cibertec.citas.feign.dtos.MascotaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "mascota-service",
        url = "http://localhost:8082"
)
public interface MascotaClient {

    @GetMapping("/api/v1/mascotas/{id}")
    public MascotaDto obtenerMascotaPorId(@PathVariable Long id);

}
