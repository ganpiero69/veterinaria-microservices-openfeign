package group.cibertec.citas.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "citas")
@Entity
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idCita;

    @Column(name = "mascota_id", nullable = false)
    private Long idMascota;

    @Column(name = "nombre_mascota", nullable = true, length = 100)
    private String nombreMascota;

    @Column(name = "nombre_duenio", nullable = true, length = 100)
    private String nombreDuenio;

    @Column(name = "motivo", nullable = true, length = 255)
    private String motivo;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDateTime fechaYHora;

    @Column(name = "estado", nullable = false)
    private String estado;

}
