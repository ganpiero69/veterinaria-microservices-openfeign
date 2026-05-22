package group.cibertec.citas.controllers;

import group.cibertec.citas.services.dtos.CitaDto;
import group.cibertec.citas.entidades.CitaEntity;
import group.cibertec.citas.services.CitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService _citaService;

    @GetMapping()
    public ResponseEntity<List<CitaEntity>> obtenerTodasLasCitas(){
        return ResponseEntity.ok(_citaService.obtenerTodasCitasConMascotas());
    }

    @PostMapping()
    public ResponseEntity<CitaEntity> guardarCita(@RequestBody CitaDto request) {

        if (request.idMascota() == null) {
            return ResponseEntity.badRequest().build();
        }
        _citaService.guardarCita(request);
        return ResponseEntity.ok().build();
    }

}
