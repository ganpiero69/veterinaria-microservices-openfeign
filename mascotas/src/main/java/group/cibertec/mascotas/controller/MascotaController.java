package group.cibertec.mascotas.controller;

import group.cibertec.mascotas.entity.Mascota;
import group.cibertec.mascotas.service.MascotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @PostMapping
    public ResponseEntity<Mascota> guardarMascota(@RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.guardarMascota(mascota));
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas() {
        return ResponseEntity.ok(mascotaService.listarMascotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascotaPorId(@PathVariable Long id) {
        return mascotaService.obtenerMascotaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}