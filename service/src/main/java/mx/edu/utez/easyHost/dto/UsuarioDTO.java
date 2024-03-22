package mx.edu.utez.easyHost.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.easyHost.modelo.Rol;
import mx.edu.utez.easyHost.modelo.Usuario;
import mx.edu.utez.easyHost.utilidades.Utilidades;
import mx.edu.utez.easyHost.validacion.anotaciones.FechaActual;
import mx.edu.utez.easyHost.validacion.anotaciones.MayorA18Anios;
import mx.edu.utez.easyHost.validacion.anotaciones.ValidarTextoGlobal;

import java.text.ParseException;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UsuarioDTO {
    Long id;
    @ValidarTextoGlobal(message = "Nombre no válido")
    @Size(max = 30, message = "No más de 30 caracteres")
    String nombre;
    @ValidarTextoGlobal(message = "Apellidos no válidos")
    @Size(max = 50, message = "No más de 50 caracteres")
    String apellidos;
    @NotBlank(message = "Correo requerido")
    @Email(message = "Formato de correo inválido")
    String correo;
    @NotBlank(message = "Contraseña requerida")
    String contrasenia;
    @NotBlank(message = "Teléfono requerido")
    @Size(min = 10, max = 10, message = "El telefono debe ser de 10 caracteres")
    @Pattern(regexp = "^[0-9]{10}$", message = "Formato de telefono incorrecto")
    String telefono;
    @NotBlank(message = "Dirección requerida")
    String direccion;
    @MayorA18Anios(message = "La fecha debe ser mayor a 18 años")
    String fechaNacimiento;
    @NotBlank(message = "Género requerido")
    @Pattern(regexp = "^(Hombre|Mujer)$", message = "El género solo puede ser 'Hombre' o 'Mujer'")
    String genero;

    public Usuario crearUsuario(Rol rol) {
        Date fechaNacimiento;
        try {
            fechaNacimiento = Utilidades.textoAFecha(this.fechaNacimiento);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        return new Usuario(
                getNombre(),
                getApellidos(),
                getCorreo(),
                getContrasenia(),
                getTelefono(),
                getDireccion(),
                fechaNacimiento,
                getGenero(),
                rol
        );
    }
}
