package mx.edu.utez.easyHost.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonString;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.easyHost.modelo.Estatus;
import mx.edu.utez.easyHost.modelo.Solicitud;
import mx.edu.utez.easyHost.modelo.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SolicitudDTO {
    Long id;

    @NotBlank(message = "Campos requeridos")
    String tipo;

    @NotBlank(message = "Campos requeridos")
    @Valid
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    String campos;

    public Solicitud crearSolicitud(){
        return new Solicitud(
                getTipo(),
                getCampos()
        );
    }

    public Solicitud actualizarSolicitud(Usuario usuario,Estatus estatus){
        return new Solicitud(
                getTipo(),
                estatus,
                getCampos(),
                usuario
                );
    }

}
