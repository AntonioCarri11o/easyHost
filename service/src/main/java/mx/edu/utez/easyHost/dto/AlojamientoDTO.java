package mx.edu.utez.easyHost.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.easyHost.modelo.Alojamiento;
import mx.edu.utez.easyHost.modelo.Anfitrion;
import mx.edu.utez.easyHost.modelo.Categoria;
import mx.edu.utez.easyHost.modelo.Estatus;
import mx.edu.utez.easyHost.validacion.anotaciones.ValidarTextoGlobal;

import java.sql.Time;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AlojamientoDTO {

    Long id;

    @ValidarTextoGlobal(message = "Descripción no válida")
    @NotBlank(message = "La descripción es requerida")
    @Size(max = 200, message = "La descripción debe tener como máximo 200 caracteres")
    String descripcion;

    @ValidarTextoGlobal(message = "Ubicación no válida")
    @NotBlank(message = "La ubicación es requerida")
    @Size(max = 100, message = "La ubicación debe tener como máximo 100 caracteres")
    String ubicacion;

    @NotNull(message = "El precio es requerido")
    Double precio;

    @NotNull(message = "El número de huéspedes es requerido")
    Integer numeroHuespedes;

    @NotNull(message = "El número de camas es requerido")
    Integer numeroCamas;

    @NotNull(message = "El número de baños es requerido")
    Integer numeroBanios;

    @NotNull(message = "La disponibilidad es requerida")
    Boolean disponibilidad;

    @NotBlank(message = "La hora de recepción es requerida")
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora de recepción inválido")
    Time horaRecepcion;

    @NotBlank(message = "La hora de salida es requerida")
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "Formato de hora de salida inválido")
    Time horaSalida;

//    @NotNull(message = "El ID del anfitrión es requerido")
//    Long idAnfitrion;
//
//    @NotNull(message = "El ID de la categoría es requerido")
//    Long idCategoria;
//
//    @NotNull(message = "El ID del estatus es requerido")
//    Long idEstatus;
//
//    List<Long> extras;

    public Alojamiento crearAlojamiento(){
        return new Alojamiento(
                getDescripcion(),
                getUbicacion(),
                getPrecio(),
                getNumeroHuespedes(),
                getNumeroCamas(),
                getNumeroBanios(),
                getDisponibilidad(),
                getHoraRecepcion(),
                getHoraSalida()
//                new Anfitrion().setIdAnfitrion(getIdAnfitrion()););
        );
    }
}
