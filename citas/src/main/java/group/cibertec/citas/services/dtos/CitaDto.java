package group.cibertec.citas.services.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record CitaDto(
        Long idMascota,
        String motivo,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime fechaYHora,
        String estado
) {
}
