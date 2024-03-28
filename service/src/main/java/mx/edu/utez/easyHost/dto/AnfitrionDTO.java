package mx.edu.utez.easyHost.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.easyHost.modelo.Anfitrion;
import mx.edu.utez.easyHost.modelo.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnfitrionDTO {
        Long id;

        @NotBlank(message = "CURP requerida")
        @Size(min = 18, max = 18, message = "La CURP debe tener 18 caracteres")
        String curp;

        @NotBlank(message = "RFC requerido")
        @Size(min = 13, max = 13, message = "El RFC debe tener 13 caracteres")
        String rfc;

        @NotBlank(message = "URL de imagen de identificación requerida")
        String urlImagenIdentificacionAnfitrion;

        public Anfitrion crearAnfitrion(Usuario usuario){
                return new Anfitrion(
                        getCurp(),
                        getRfc(),
                        getUrlImagenIdentificacionAnfitrion(),
                        usuario
                );
        }

}
