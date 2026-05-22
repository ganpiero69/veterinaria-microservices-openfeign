package group.cibertec.citas.feign.dtos;

public record MascotaDto(
        Long id,
        String nombre,
        String especie,
        String raza,
        Integer edad,
        String nombreDuenio
) {
}
